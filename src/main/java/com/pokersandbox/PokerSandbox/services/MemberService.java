package com.pokersandbox.PokerSandbox.services;

import com.pokersandbox.PokerSandbox.models.Member;
import com.pokersandbox.PokerSandbox.models.dto.MemberRegister;
import com.pokersandbox.PokerSandbox.repositories.MemberRepo;
import com.pokersandbox.PokerSandbox.utilities.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class MemberService {

    private final MemberRepo memberRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService (MemberRepo memberRepo, PasswordEncoder passwordEncoder){
        this.memberRepo = memberRepo;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Register Method for new member with password validator.
     */
    public String registerMember(MemberRegister newMember) {
        Member member = new Member();
        Date date = new Date();

        if(!Validators.validateEmail(newMember.getEmail()))
            return "Not a valid Email, Please use a valid email";

        if(memberRepo.existsByEmail(newMember.getEmail()))
            return "The email " + newMember.getEmail() + " is already in use, please log in";

        if(memberRepo.existsByUsername(newMember.getUsername()))
            return "The username is already in use";

        if(Validators.validatePassword(newMember.getPassword())) {
            member.setUsername(newMember.getUsername());
            member.setPassword(passwordEncoder.encode(newMember.getPassword()));
            member.setEmail(newMember.getEmail());

            LocalDate today = LocalDate.now();
            member.setDate_registered(today);

            memberRepo.save(member);
        }

        return "Account created";
    }
}

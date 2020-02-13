package com.pokersandbox.PokerSandbox.services;

import com.pokersandbox.PokerSandbox.models.Member;
import com.pokersandbox.PokerSandbox.models.dao.MemberRegister;
import com.pokersandbox.PokerSandbox.models.dao.MemberUpdate;
import com.pokersandbox.PokerSandbox.models.dao.PasswordUpdate;
import com.pokersandbox.PokerSandbox.repositories.MemberRepo;
import com.pokersandbox.PokerSandbox.utilities.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

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
     * Register Method for new member
     * password validation
     * email validation
     * username validation
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

    /**
     * PUT methods for updating member fields
     */
    public String updateMember(MemberUpdate memberUpdate, Long id) {
        Member member = getMemberById(id);

        if(memberRepo.existsByEmail(memberUpdate.getEmail()))
            return "Email " + memberUpdate.getEmail() + " is already being used";

        if(memberRepo.existsByUsername(memberUpdate.getUsername()))
            return "The username is already in use";

        if(Validators.validateEmail(memberUpdate.getEmail())){
            member.setEmail(memberUpdate.getEmail());
            member.setUsername(memberUpdate.getUsername());
            member.setCountry(memberUpdate.getCountry());
            member.setState(memberUpdate.getState());

            memberRepo.save(member);
            return "Updated";
        }
        else
            return "Not a valid Email";
    }
    public Boolean updateMemberPassword(PasswordUpdate passwordUpdate, Long id) {
        Member member = getMemberById(id);

        if(Validators.validatePassword(passwordUpdate.getNewPassword())){
            member.setPassword(passwordUpdate.getNewPassword());
            memberRepo.save(member);
            return true;
        }

        return false;
    }

    /**
     * GET methods for member
     */
    public Member getMemberById(Long id) {
        Optional<Member> member = memberRepo.findById(id);
        return member.orElse(null);
    }



}

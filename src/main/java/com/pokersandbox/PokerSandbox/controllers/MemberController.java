package com.pokersandbox.PokerSandbox.controllers;

import com.pokersandbox.PokerSandbox.models.Member;
import com.pokersandbox.PokerSandbox.models.dao.MemberRegister;
import com.pokersandbox.PokerSandbox.models.dao.MemberUpdate;
import com.pokersandbox.PokerSandbox.models.dao.PasswordUpdate;
import com.pokersandbox.PokerSandbox.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    /**
     *POST request -> Register new member
     */
    @PostMapping("/member/register")
    public ResponseEntity<String> registerMember (@RequestBody MemberRegister newMember){
        return new ResponseEntity<>(memberService.registerMember(newMember), HttpStatus.CREATED);
    }

    /**
     * PUT request -> update member
     */
    @PutMapping("/member/update/{id}")
    public ResponseEntity<String> updateMember (@RequestBody MemberUpdate memberUpdate, @PathVariable Long id){
        return new ResponseEntity<>(memberService.updateMember(memberUpdate, id), HttpStatus.OK);
    }

    @PutMapping("/member/update/password/{id}")
    public ResponseEntity<Boolean> updateMemberPassword(@RequestBody PasswordUpdate passwordUpdate, @PathVariable Long id){
        return new ResponseEntity<>(memberService.updateMemberPassword(passwordUpdate, id), HttpStatus.OK);
    }

    /**
     * GET request
     */
    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }


}

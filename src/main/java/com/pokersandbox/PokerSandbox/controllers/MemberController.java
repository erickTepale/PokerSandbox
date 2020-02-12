package com.pokersandbox.PokerSandbox.controllers;

import com.pokersandbox.PokerSandbox.models.Member;
import com.pokersandbox.PokerSandbox.models.dto.MemberRegister;
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

    @PostMapping("/member/register")
    public ResponseEntity<String> registerMember (@RequestBody MemberRegister newMember){
        return new ResponseEntity<>(memberService.registerMember(newMember), HttpStatus.CREATED);
    }

    /**
     * GET request
     */
    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }


}

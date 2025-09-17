package com.jarvis.game_club.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jarvis.game_club.modal.MemberModal;
import com.jarvis.game_club.repository.MemberRepository;

@RestController
@RequestMapping("/members")

public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public MemberModal addMember(@RequestBody MemberModal member) {
        member.setId(null);
        return memberRepository.save(member);
    }

    @GetMapping
    public List<MemberModal> getAll() {
        return memberRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public MemberModal findById(@PathVariable String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public MemberModal update(@PathVariable String id, @RequestBody MemberModal updatedMember)
    {
        MemberModal oldMember = memberRepository.findById(id).get();
        oldMember.setName(updatedMember.getName());
        oldMember.setBalance(updatedMember.getBalance());
        oldMember.setPhone(updatedMember.getPhone());
        MemberModal savedMember = memberRepository.save(oldMember);
        return savedMember;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable String id) {
        memberRepository.deleteById(id);
    }


}

package com.jarvis.game_club.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.game_club.exceptions.IdNotPresentException;
import com.jarvis.game_club.modal.MemberModal;
import com.jarvis.game_club.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;


    public MemberModal create(MemberModal member) {
        member.setId(null);
        return memberRepository.save(member);
    }


    public List<MemberModal> findAll() {
        return memberRepository.findAll();
    }

    public MemberModal findById(String idString) throws IdNotPresentException {
        Optional<MemberModal> member = memberRepository.findById(idString);
        if(member.isEmpty()) {
            throw new IdNotPresentException("Member with ID " + idString + " not found.");
        }
        return member.get();
    }

    public MemberModal findByPhone(String phone) throws IdNotPresentException {
        MemberModal member = memberRepository.findByPhone(phone);
        if(member == null) {
            throw new IdNotPresentException("Member with phone " + phone + " not found.");
        }
        return member;
    }

    public MemberModal updateMember(String idString, MemberModal updatedMember) throws IdNotPresentException {
        Optional<MemberModal> existingMemberOpt = memberRepository.findById(idString);
        if(existingMemberOpt.isEmpty()) {
            throw new IdNotPresentException("Member with ID " + idString + " not found.");
        }
        MemberModal existingMember = existingMemberOpt.get();
        existingMember.setName(updatedMember.getName());
        existingMember.setBalance(updatedMember.getBalance());
        existingMember.setPhone(updatedMember.getPhone());
        return memberRepository.save(existingMember);
    }

    public void deleteMember(String idString) throws IdNotPresentException {
        Optional<MemberModal> member = memberRepository.findById(idString);
        if(member.isEmpty()) {
            throw new IdNotPresentException("Member with ID " + idString + " not found.");
        }
        memberRepository.deleteById(idString);
    }
}
package com.example.springweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springweb.domain.Member;
import com.example.springweb.repository.MemberRepository;

@Service 
public class MemberService {
    
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member updateMember(Long id, Member member) {
        return memberRepository.update(id, member);
    }

    public boolean deleteMember(Long id) {
        return memberRepository.delete(id);
    }
}

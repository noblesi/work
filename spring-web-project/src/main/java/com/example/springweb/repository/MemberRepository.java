package com.example.springweb.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.springweb.domain.Member;

@Repository 
public class MemberRepository {
    
    private final Map<Long, Member> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public Member save(Member member) {
        long id = sequence.incrementAndGet();
        member.setId(id);
        store.put(id, member);

        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public Member update(Long id, Member member) {
        Member existingMEmber = store.get(id);

        if(existingMEmber == null) {
            return null;
        }

        existingMEmber.setName(member.getName());
        existingMEmber.setEmail(member.getEmail());

        return existingMEmber;
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}

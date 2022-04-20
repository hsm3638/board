package com.study.board.service;

import com.study.board.entity.Member;
import com.study.board.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean login(Member member) {

        Optional<Member> user = memberRepository.findById(member.getLoginId());

        if(user == null) {
            return false;
        }

        return true;

    }

}

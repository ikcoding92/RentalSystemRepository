package com.ikeda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikeda.entity.Member;
import com.ikeda.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    




    /**
     * 会員一覧を取得
     */
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    /**
     * ID を指定して会員を取得
     */
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    /**
     * 会員を削除
     */
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    /**
     * 会員情報を保存（新規 or 更新）
   一旦コメントアウトにしてあります。
    public Member save(Member member) {
        return memberRepository.save(member);
    }  */
}

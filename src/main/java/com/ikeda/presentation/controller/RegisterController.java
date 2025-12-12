package com.ikeda.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ikeda.entity.Member;
import com.ikeda.presentation.form.MemberForm;
import com.ikeda.service.RegisterService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("memberForm") MemberForm memberForm,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";   // エラーがある場合は入力画面へ戻す
        }

        // ★ MemberForm → Member（Entity）へ変換（全部必要）
        Member member = new Member();
        member.setFirstName(memberForm.getFirstName());
        member.setLastName(memberForm.getLastName());
        member.setUsername(memberForm.getUsername());
        member.setEmail(memberForm.getEmail());
        member.setZip(memberForm.getZip());
        member.setAddress(memberForm.getAddress());
        member.setPhone(memberForm.getPhone());

        // パスワードは RegisterService 内でハッシュ化される
        member.setPassword(memberForm.getPassword());

        // ★ RegisterService に Entity を渡す（正しい）
        registerService.register(member);

        return "redirect:/login"; // 完了後はログイン画面へ
    }
}

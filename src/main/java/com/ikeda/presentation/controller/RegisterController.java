package com.ikeda.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ← modelを使用するためのものを追加
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ikeda.presentation.com.ikeda.ParamForm;
import com.ikeda.presentation.form.MemberService;

@Controller
public class RegisterController {

  @Autowired
  private MemberService memberService; // 登録処理用サービス

    // GET /register → 登録フォーム表示
  @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("paramForm", new ParamForm());
        return "register";
    }

    // POST /register → 登録処理
    @PostMapping("/register")
    public String registerMember(@ModelAttribute ParamForm paramForm, Model model) {

        boolean result = memberService.register(paramForm);

        if(result) {
            // 登録成功 → ログイン画面へ
            return "redirect:/login";
        } else {
            // 登録失敗 → エラーメッセージ表示
            model.addAttribute("error", "登録に失敗しました。もう一度入力してください。");
            return "register";
        }
    }
}

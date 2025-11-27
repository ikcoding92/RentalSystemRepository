package com.ikeda.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ikeda.presentation.com.ikeda.ParamForm;

//@Autowired
//private LoginService loginService; // ログインチェック用

@Controller
public class LoginController {

    // GET /login → ログイン画面表示
    @GetMapping("/login")// /login にアクセスしたときにログイン画面を表示する
    public String showLoginForm() {
        return "login"; // login.html を表示
    }
    
    // POST /login → ログイン処理
    @PostMapping("/login")
    public String login(@ModelAttribute ParamForm paramForm, Model model) {
        
        // 簡易ログインチェック（固定値）
        String correctEmail = "test@example.com";
        String correctPassword = "password123";

        if(correctEmail.equals(paramForm.getEmail()) &&
           correctPassword.equals(paramForm.getPassword())) {
            // ログイン成功 → ホーム画面に遷移
            return "redirect:/home";
        } else {
            // ログイン失敗 → login.html に戻す + エラーメッセージ
            model.addAttribute("error", "メールアドレスかパスワードが間違っています");
            return "login";
        }
    }


    // GET /home → ホーム画面表示
    @GetMapping("/home")
    public String toHome() {
        return "index";
    }
}





/*ポイント解説

@PostMapping("/login")
→ /login に POST で送られたデータを受け取る

@ModelAttribute ParamForm paramForm
→ login.html のフォームから送られた email と password を ParamForm に格納

Model model
→ エラーメッセージなどを画面に渡すときに使用

固定値でログインチェック
→ 簡易版なので、後で DB 連携に変更可能

ログイン成功 → 仮で home.html に遷移
→ 後で本来のトップページに変更可能

ログイン失敗 → login.html に戻してエラー表示
 */




package com.ikeda.presentation.form;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberForm {

    private Long id;

    @NotBlank(message = "名は必須です")
    private String firstName;

    @NotBlank(message = "姓は必須です")
    private String lastName;

    @NotBlank(message = "ユーザーネームは必須です")
    private String username;

    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String email;

    @NotBlank(message = "郵便番号は必須です")
    private String zip;

    @NotBlank(message = "住所は必須です")
    private String address;

    @NotBlank(message = "電話番号は必須です")
    private String phone;

    @NotBlank(message = "パスワードは必須です")
    @Size(min = 8, message = "パスワードは8文字以上です")
    private String password;

    // パスワード確認
    @NotBlank(message = "パスワード確認を入力してください")
    private String passwordConfirm;

    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

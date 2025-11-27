package com.ikeda.presentation.com.ikeda;

import lombok.Data;

@Data
public class ParamForm {
    // ログイン用
    private String email;     // メールアドレス
    private String password;  // パスワード
    // 会員登録用
    private String lastName;         // 姓
    private String firstName;        // 名
    private String lastNameKana;     // フリガナ（セイ）
    private String firstNameKana;    // フリガナ（メイ）
    private String birthday;         // 生年月日
    private String postalCode;       // 郵便番号
    private String prefecture;       // 都道府県
    private String city;             // 市区町村
    private String street;           // 番地
    private String building;         // 建物名・部屋番号（任意）
    private String phone;            // 連絡先
    private String passwordConfirm;  // パスワード確認
}



/*package com.ikeda;

import java.io.Serializable;
import lombok.Data;

@Data
public class ParamForm {

	private String name;
}
*/
package com.ikeda.presentation.form;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ikeda.presentation.com.ikeda.ParamForm;

@Service
public class MemberService {

    private List<ParamForm> memberList = new ArrayList<>(); // 仮保存用

    // 会員登録
    public boolean register(ParamForm paramForm) {
        // ここでは email が重複していないか簡単チェック
        for(ParamForm member : memberList) {
            if(member.getEmail().equals(paramForm.getEmail())) {
                return false; // 登録失敗（メール重複）
            }
        }

        memberList.add(paramForm); // 仮保存
        return true; // 登録成功
    }

    // 確認用：登録済み会員リスト
    public List<ParamForm> getMembers() {
        return memberList;
    }
}

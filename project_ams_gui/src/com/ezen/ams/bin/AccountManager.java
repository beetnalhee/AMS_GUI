package com.ezen.ams.bin;

import com.ezen.ams.view.AccountFrame;

public class AccountManager {
    public static void main(String[] args) {
        AccountFrame accountFrame = new AccountFrame(":::Ezen - Bank AMS:::"); // 타이틀
        accountFrame.initComponents();
        accountFrame.setSize(570,500);
        accountFrame.setResizable(false); // 좌표값 배치시, 화면조정 불가
        accountFrame.setVisible(true);

    }
}

package com.ezen.ams.bin;

import com.ezen.ams.view.AccountFrame;

import java.awt.*;

public class AMS {
    public static void main(String[] args) {
        AccountFrame accountFrame = new AccountFrame(":::Ezen - Bank AMS:::"); // 타이틀
        accountFrame.initComponents();
        accountFrame.eventRegister();
        accountFrame.setSize(570,500);
        accountFrame.setResizable(false); // 좌표값 배치시, 화면조정 불가
        setCenterScreen(accountFrame);
        accountFrame.setVisible(true);

    }

    public static void setCenterScreen(Frame frame){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int locationX = (screenWidth - frameWidth) / 2;
        int locationY = (screenHeight - frameHeight) / 2;
        frame.setLocation(locationX, locationY);
    }
}

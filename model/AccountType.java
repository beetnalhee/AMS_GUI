package com.ezen.ams.model;

// 한글이 필요한 경우
public enum AccountType {
    ACCOUNT("입출금 계좌"), MINUS_ACCOUNT("마이너스 계좌");

    private String name;
    private AccountType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

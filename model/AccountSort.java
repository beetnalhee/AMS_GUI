package com.ezen.ams.model;

public enum AccountSort {
     ACCOUNT_NUMBER("계좌번호"), ACCOUNT_OWNER("예금주"), ACCOUNT_BALANCE("잔 액");

    private String sortname;
    private AccountSort(String sortname) {
        this.sortname = sortname;
    }

    public String getSortname() {
        return sortname;
    }

}

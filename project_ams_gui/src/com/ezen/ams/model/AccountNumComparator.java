package com.ezen.ams.model;

import com.ezen.ams.model.Account;

import java.util.Comparator;

public class AccountNumComparator implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getAccountNum().compareTo(o2.getAccountNum());
    }
}

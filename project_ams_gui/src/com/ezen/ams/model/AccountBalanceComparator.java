package com.ezen.ams.model;

import com.ezen.ams.model.Account;

import java.util.Comparator;

public class AccountBalanceComparator implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        return (int)(o2.getBalance() - o1.getBalance());
    }
}

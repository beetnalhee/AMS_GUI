package com.ezen.ams.model;

import com.ezen.ams.exception.InsufficientException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

/**
 * TreeMap 콜렉션을 이용한 계좌 목록 관리
 */

public class AccountService {

    private TreeMap<String, Account>  accounts;

    public AccountService() {
        accounts = new TreeMap<>();
    }


    public List<Account> getAccounts() {
        return new ArrayList<Account>(accounts.values());

        //=========================수정전=========
        //    public Collection<Account> getAccounts() {
//        return accounts.values();
////        return new ArrayList<Account>(accounts.value);
    }

    public int getCount() {
        return accounts.size();
    }

    // 계좌 생성
    public void addAccount(Account account){
        accounts.put(account.getAccountNum(),account);
    }

    // 입금
    public long depositAccount(String accountNum, long money)throws InsufficientException {
        if(money < 1000){
            throw new InsufficientException("입금하고자 하는 금액이 1,000원 미만이거나 음수일 수 없습니다.", 100);
        }
        Account findAccount = accounts.get(accountNum);
        if(findAccount == null) {
            throw new InsufficientException("입금하고자 하는 계좌가 존재하지 않습니다", 200);
        }
                return findAccount.deposit(money);
    }

    // 출금
    public long withdrawAccount(String accountNum, long money) throws InsufficientException{
        if(money < 1000){
            throw new InsufficientException("출금하고자 하는 금액이 1,000원 미만이거나 음수일 수 없습니다.", 110);
        }
        Account findAccount = accounts.get(accountNum);
        if(findAccount == null){
            throw new InsufficientException("출금하고자 하는 계좌가 존재하지 않습니다",210);
        }
        if(findAccount.getBalance() < money){
            throw new InsufficientException("출금 잔액이 부족합니다",230);
        }
            return findAccount.withdraw(money);
    }

    // 계좌 검색
    public Account findAccount(String accountNum){
           return accounts.get(accountNum);
    }

    // 예금주 이름으로 계좌 검색
    public List<Account> findAccountByAccountOwner(String accountOwner){
        List<Account> findAccounts = new ArrayList<>();
        Collection<Account> values = accounts.values();
        for (Account account : values) {
            String owner = account.getAccountOwner();
            if(owner.equals(accountOwner)){
                findAccounts.add(account);
            }
        }
            return findAccounts;
    }

    //------------------------------------------



    // 계좌 삭제
    public boolean removeAccount(String accountNum){
        Account account = accounts.remove(accountNum);
            if(account != null){
                   return true;
                }
        return false;
            }

            // 테스트를 위한 main
    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        accountService.addAccount(new Account("2222-1111","한라봉",1111,1000));
        accountService.addAccount(new Account("2222-2222","두리안",1111,1000));
        accountService.addAccount(new MinusAccount("2222-3333","레드향",1111,1000,10000));

        Collection<Account> accounts = accountService.getAccounts();
        if(!accounts.isEmpty()){
            for (Account account : accounts) {
                System.out.println(account);
            }
        }

        String findAccountNumber = "2222-1111";
        Account findAccount = accountService.findAccount(findAccountNumber);
        if(findAccount !=null){
            System.out.println("검색된 계좌 : " + findAccount);
        }else {
            System.out.println("검색된 계좌 없음");
        }

    }
}


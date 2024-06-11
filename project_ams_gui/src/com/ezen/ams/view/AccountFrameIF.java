package com.ezen.ams.view;

import com.ezen.ams.model.*;
import com.ezen.ams.util.Validator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Frame을 이용한 계좌 메인 화면
 */
public class AccountFrameIF extends Frame {
    private AccountService accountService;
    Choice accountChoice, accountSortChoice;
    TextField accountNumberTF, accountOwnerTF, passwordTF, depositAmountTF, withdrawAmountTF, borrowMoneyTF;
    Button searchButton, deleteButton, findOwnerBtn, newAccountBtn, allAccountBtn;
    TextArea listTA;
    Label accountKindLabel, accountNumLabel, ownerLabel, passwdLabel, depositLabel, loanLabel, accountListLabel, currencyLabel;


    public AccountFrameIF(String title) {
        super(title);

        //필드
        accountService = new AccountService();
        accountService.addAccount(new Account("2222-1111", "한라봉", 1111, 1000));
        accountService.addAccount(new Account("2222-2222", "두리안", 1111, 1000));
        accountService.addAccount(new MinusAccount("9999-1111", "레드향", 1111, 1000, 10000));

        accountNumberTF = new TextField();
        accountOwnerTF = new TextField();
        passwordTF = new TextField();
        depositAmountTF = new TextField();
        withdrawAmountTF = new TextField();
        borrowMoneyTF = new TextField();


        //라벨
        accountKindLabel = new Label("계좌종류");
        accountNumLabel = new Label("계좌번호");
        ownerLabel = new Label("예금주명");
        passwdLabel = new Label("비밀번호");
        depositLabel = new Label("입금금액");
        loanLabel = new Label("대출금액");
        accountListLabel = new Label("계좌목록");
//        currencyLabel = new Label("(단위 : 원)");


        accountChoice = new Choice(); // choice는 enum 사용
        accountChoice.add("-- 계좌종류 --");
        //accountChoice.add("입출금계좌");
        //accountChoice.add("마이너스계좌");
        AccountType[] accountTypes = AccountType.values();
        for (AccountType accountType : accountTypes) {
            accountChoice.add(accountType.getName());
        }

        accountSortChoice = new Choice(); // enum
        accountSortChoice.add("--정렬기준--");
        AccountSort[] accountSorts = AccountSort.values();
        for (AccountSort accountSort : accountSorts) {
            accountSortChoice.add(accountSort.getSortname());
        }


        //버튼
        searchButton = new Button("조  회");
        deleteButton = new Button("삭  제");
        findOwnerBtn = new Button("검  색");
        newAccountBtn = new Button("신규등록");
        allAccountBtn = new Button("전체조회");

        listTA = new TextArea();
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void initComponents() {
        setLayout(null);
        accountChoice.setBounds(100, 50, 100, 20);
        accountSortChoice.setBounds(440, 200, 100, 20);

        searchButton.setBounds(280, 80, 60, 20);
        deleteButton.setBounds(350, 80, 60, 20);
        findOwnerBtn.setBounds(280, 110, 60, 20);
        newAccountBtn.setBounds(280, 170, 80, 20);
        allAccountBtn.setBounds(370, 170, 80, 20);

        listTA.setBounds(20, 230, 540, 250);

        accountKindLabel.setBounds(20, 50, 50, 20);
        accountNumLabel.setBounds(20, 80, 50, 20);
        ownerLabel.setBounds(20, 110, 50, 20);
        passwdLabel.setBounds(20, 140, 50, 20);
        loanLabel.setBounds(20, 170, 50, 20);
        depositLabel.setBounds(280, 140, 60, 20);
        accountListLabel.setBounds(20, 200, 50, 20);
        //     currencyLabel.setBounds(460, 200, 70, 20);

        accountNumberTF.setBounds(100, 80, 170, 20);
        accountOwnerTF.setBounds(100, 110, 170, 20);
        passwordTF.setBounds(100, 140, 170, 20);
        borrowMoneyTF.setBounds(100, 170, 170, 20);
        depositAmountTF.setBounds(350, 140, 170, 20);

        add(accountChoice);
        add(searchButton);
        add(listTA);
        add(deleteButton);
        add(accountKindLabel);
        add(accountNumLabel);
        add(ownerLabel);
        add(accountNumberTF);
        add(findOwnerBtn);
        add(depositLabel);
        add(loanLabel);
        add(passwdLabel);
        add(accountOwnerTF);
        add(passwordTF);
        add(borrowMoneyTF);
        add(depositAmountTF);
        add(newAccountBtn);
        add(allAccountBtn);
        add(accountListLabel);
//        add(currencyLabel);
        add(accountSortChoice);

        setEnable(false);
        printAccounts();

    }

    /**
     * 각각의 이벤트소스에 이벤트 리스너 등록 (+종료 메소드 재사용)
     */
    public void eventRegister() {
        // 종료 처리
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                exit();
            }
        });

        // 신규계좌 등록 이벤트 처리
        newAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAccount();
            }
        });

        // 계좌 종류 선택 이벤트 처리
        accountChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selectAccountType();
                }
            }
        });

        // 전체계좌 목록 이벤트 처리
        allAccountBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printAccounts();
            }
        });


//        // 모든 텍스트필드 포커스 이벤트 처리
//        Component[] components =  getComponents();
//        for (Component component : components) {
//            if(component instanceof TextField){
//                component.addFocusListener(new FocusAdapter() {
//                    @Override
//                    public void focusGained(FocusEvent e) {
//                        TextField tf = (TextField) component;
//                        tf.setText("");
//                    }
//                });
//            }
//        }

        // 모든 텍스트필드 포커스 이벤트 처리
        accountNumberTF.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                Component[] components = getComponents();
                for (Component component : components) {
                    if (component instanceof TextField) {
                        ((TextField) component).setText("");
                        component.setForeground(Color.black);
                    }
                }
            }
        });


        // 계좌번호 조회 이벤트 처리
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findByAccountNumber();
            }
        });

        // 예금주 검색 이벤트 처리
        findOwnerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findByAccountOwner();
            }
        });
        // 계좌삭제 이벤트 처리
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAccount();
            }
        });
        // 정렬 이벤트 ---------------------------
        accountSortChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    sortAccounts();
                }
            }
        });
    }


    /**
     * 신규 계좌 등록 기능(메소드)
     */
    private void openAccount() {
        String accountNumber = null;
        String accountOwner = null;
        int password = 0;
        long restMoney = 0L;
        long borrowMoney = 0L;


        accountNumber = accountNumberTF.getText();
        accountOwner = accountOwnerTF.getText();
        String inputPasswd = passwordTF.getText();
        String inputMoney = depositAmountTF.getText();


        // boolean empty = false;
        // #1. 1차 검증 : 입력 필드에 값이 입력 안되었거나 또는 빈공백문자 입력 검증
        if (!Validator.isText(accountNumber)) {
            fieldError(accountNumberTF, "필수입력 항목입니다.");
        }

        if (!Validator.isText(accountOwner)) {
            fieldError(accountOwnerTF, "필수입력 항목입니다.");
        }

        if (!Validator.isText(inputPasswd)) {
            fieldError(passwordTF, "필수입력 항목입니다.");
        }

        if (!Validator.isText(inputMoney)) {
            fieldError(depositAmountTF, "필수입력 항목입니다.");
        }

        // #2. 2차 검증 : 유효한 입력 형식 검증 - 비밀번호, 입금액

        if (!Validator.isNumber(inputPasswd)) {
            fieldError(passwordTF, "숫자형식이어야 합니다.");
        }

        if (!Validator.isNumber(inputMoney)) {
            fieldError(depositAmountTF, "숫자형식이어야 합니다.");
        }

        password = Integer.parseInt(inputPasswd);
        restMoney = Long.parseLong(inputMoney);

        // 신규 계좌 생성
        Account newAccount = null;
        // 입출금 계좌인 경우
        if (accountChoice.getSelectedItem().equals(AccountType.valueOf("ACCOUNT").getName())) {
            newAccount = new Account(accountNumber, accountOwner, password, restMoney);
        } else if (accountChoice.getSelectedItem().equals(AccountType.valueOf("MINUS_ACCOUNT").getName())) {
            newAccount = new MinusAccount(accountNumber, accountOwner, password, restMoney, borrowMoney);
            String inputBorrowMoney = borrowMoneyTF.getText();
            if (!Validator.isText(inputBorrowMoney)) {
                fieldError(borrowMoneyTF, "필수입력 항목입니다.");
            }

            if (!Validator.isNumber(inputBorrowMoney)) {
                fieldError(borrowMoneyTF, "숫자형식이어야 합니다.");
            }

            borrowMoney = Long.parseLong(inputBorrowMoney);
            newAccount = new MinusAccount(accountNumber, accountOwner, password, restMoney, borrowMoney);

        }
        accountService.addAccount(newAccount);
        // 사용자에게 신규등록 메세지 보여주기
        showMessage("※ 신규계좌(" + newAccount.getAccountNum() + ") 가 정상 등록 되었습니다.");
        // 신규계좌 개설 후 입력필드 초기화
        setClearField();

    }
    /**
     * 계좌번호로 등록 계좌 조회
     */
    // 계좌번호로 조회
    private void findByAccountNumber() {
        if (!accountNumberTF.isEnabled()) {
            accountNumberTF.setEnabled(true);
            accountNumberTF.requestFocus();
        }

        String findAccountNum = accountNumberTF.getText();
        if (!Validator.isText(findAccountNum)) {
            fieldError(accountNumberTF, "검색 계좌번호를 입력하세요.");
            return;
        } else {
            Account findAccount = accountService.findAccount(findAccountNum);
//            System.out.println(findAccount);
            if (findAccount != null) {
                listTA.setText("");
                printHeader();
                String accountType = null;
                long borrowMoney = 0L;
                if (findAccount instanceof MinusAccount) {
                    accountType = AccountType.valueOf("MINUS_ACCOUNT").getName();
                    borrowMoney = ((MinusAccount) findAccount).getBorrowMoney();
                } else {
                    accountType = AccountType.valueOf("ACCOUNT").getName();
//                    borrowMoney = 0L;
                }
                printRow(accountType,
                        findAccount.getAccountNum(),
                        findAccount.getAccountOwner(),
                        findAccount.getBalance(),
                        borrowMoney);
            } else {
                showErrorMessage("※ 해당계좌가 존재하지 않습니다.");

            }
        }
    }

    // 예금주 이름으로 조회
    private void findByAccountOwner() {
        if (!accountOwnerTF.isEnabled()) {
            accountOwnerTF.setEnabled(true);
            accountOwnerTF.requestFocus();
        }

        String findAccountOwner = accountOwnerTF.getText();
        if (!Validator.isText(findAccountOwner)) {
            fieldError(accountOwnerTF, "예금주명을 입력하세요.");
            return;
        } else {
            List<Account> findAccountName = accountService.findAccountByAccountOwner(findAccountOwner);
            listTA.setText("");
            String accountType = null;
            long borrowMoney = 0L;
            if (findAccountName instanceof MinusAccount) {
                accountType = AccountType.valueOf("MINUS_ACCOUNT").getName();
                borrowMoney = ((MinusAccount) findAccountName).getBorrowMoney();
            } else {
                accountType = AccountType.valueOf("ACCOUNT").getName();
            }
            if (!findAccountName.isEmpty()) {
                printHeader();  //-------------
                for (Account account : findAccountName) {
                    printRow(accountType,
                            ((Account) account).getAccountNum(),
                            ((Account) account).getAccountOwner(),
                            ((Account) account).getBalance(),
                            borrowMoney);
                }

            } else {
                showErrorMessage("※ 해당계좌가 존재하지 않습니다.");

            }
        }
    }

    // 계좌번호로 계좌삭제
    private void removeAccount() {
        if (!accountNumberTF.isEnabled()) {
            accountNumberTF.setEnabled(true);
            accountNumberTF.requestFocus();
        }

        String removeAccountNum = accountNumberTF.getText();
        if (!Validator.isText(removeAccountNum)) {
            fieldError(accountNumberTF, "삭제하실 계좌번호를 입력하세요");
            return;
        } else {
            boolean removeAccounts = accountService.removeAccount(removeAccountNum);
            if (removeAccounts) {
                listTA.setText("※ 삭제 완료되었습니다.");

            } else {
                listTA.setText("해당하는 계좌가 없습니다");

            }
        }
    }

    // 유효성 검증 에러메시지 출력
    private void fieldError(TextField tf, String errorMessage) {
        tf.setForeground(Color.red);
        tf.setText(errorMessage);
    }

    // 사용자에게 메시지 보여주는 기능
    private void showMessage(String message) {
        listTA.setForeground(Color.black);
        listTA.setText(message);
    }

    // 오류 메세지 보여주는 기능
    private void showErrorMessage(String errorMessage) {
        listTA.setForeground(Color.red);
        listTA.setText(errorMessage);
    }

    // 계좌 종류 선택 기능 (활성화 or 비활성화)
    private void selectAccountType() {
        if (accountChoice.getSelectedIndex() == 0) {
            setEnable(false);
        } else {
            String accountType = accountChoice.getSelectedItem();
            accountNumberTF.setEnabled(true);
            accountOwnerTF.setEnabled(true);
            passwordTF.setEnabled(true);
            depositAmountTF.setEnabled(true);

            if (accountType.equals(AccountType.valueOf("ACCOUNT").getName())) {
                borrowMoneyTF.setEnabled(false);
            } else if (accountType.equals(AccountType.valueOf("MINUS_ACCOUNT").getName())) {
                borrowMoneyTF.setEnabled(true);
            }
        }
    }

    //==============================================================================
    // 계좌 정렬 선택 기능


    /**
     * 정렬방식 선택에 따른 계좌 목록 출력
     */
    private void sortAccounts(){
        List<Account> accounts =  accountService.getAccounts();
        if(accountSortChoice.getSelectedIndex() != 0){
            String sortType = accountSortChoice.getSelectedItem();
            // 계좌번호 정렬
            if(sortType.equals(AccountSort.valueOf("ACCOUNT_NUMBER").getSortname())){
                Collections.sort(accounts, new AccountNumComparator());
            } else if(sortType.equals(AccountSort.valueOf("ACCOUNT_OWNER").getSortname())){
                Collections.sort(accounts, new AccountOwnerComparator());
            } else if(sortType.equals(AccountSort.valueOf("ACCOUNT_BALANCE").getSortname())){
                Collections.sort(accounts, new AccountBalanceComparator());
            }
            printAccounts(accounts);
        }
    }




    /**
     * 테이블 헤더 출력 기능
     */
    private void printHeader() {
        listTA.append("----------------------------------------------------------------------------------\n");
        String header = String.format(" %1$-15s\t%2$-13s\t%3$-8s\t%4$-15s\t%5$-15s", "계좌종류", "계좌번호", " 예금주", "현재잔액", "대출금액");
        listTA.append(header + "\n");
        listTA.append("==================================================================================\n");
    }

    /**
     * 전체 계좌 목록 출력 기능
     */

    private void printAccounts() {
        List<Account> accounts = accountService.getAccounts();
        printAccounts(accounts);
    }

    private void printAccounts(List<Account> accounts) {
        listTA.setText("");
        listTA.setForeground(Color.black);
        if (accounts.isEmpty()) {
            // showErrorMessage("※ 등록된 계좌가 없습니다."); 방법 두개중, 골라서 사용
            // Swing API활용
            JOptionPane.showMessageDialog(null,
                    "등록된 계좌가 없습니다.",
                    "검색결과",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        printHeader();
        for (Account account : accounts) {
            String accountType = null;
            String accountNum = null;
            String accountOwner = null;
            long balance = 0L;
            long borrowMoney = 0L;
            if (account instanceof MinusAccount) {
                accountType = AccountType.valueOf("MINUS_ACCOUNT").getName();
                borrowMoney = ((MinusAccount) account).getBorrowMoney();
            } else {
                accountType = AccountType.valueOf("ACCOUNT").getName();
            }
            accountNum = account.getAccountNum();
            accountOwner = account.getAccountOwner();
            balance = account.getBalance();
            printRow(accountType, accountNum, accountOwner, balance, borrowMoney);

        }
    }

    private void printRow(String accountType, String accountNum, String accountOwner, long balance, long borrowMoney) {
        String row = String.format(" %1$-15s\t%2$-15s\t%3$-10s\t%4$-,15d\t%5$,-15d", accountType, accountNum, accountOwner, balance, borrowMoney);
        listTA.append(row + "\n");
    }

    /**
     * 프로그램 종료 기능 (메소드)
     */
    private void exit() {
        int confirm = JOptionPane.showConfirmDialog(null, "프로그램을 종료합니다.", "종료 확인", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (confirm == JOptionPane.OK_OPTION) {
            // OS로부터 빌려온 리소스 반납
            dispose();
            setVisible(false);
            System.exit(0);
        }
    }

    /**
     * 전체 컴포넌트 비활성화 기능 (방법1)

     private void setEnable(boolean enable){
     accountNumberTF.setEnabled(enable);
     accountOwnerTF.setEnabled(enable);
     passwordTF.setEnabled(enable);
     depositAmountTF.setEnabled(enable);
     // 대출금액을 빠뜨리는 실수 .. 발생
     }*/

    /**
     * 전체 컴포넌트 비활성화 기능 (방법2)
     */
    private void setEnable(boolean enable) {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof TextField) {
                component.setEnabled(enable);
            }
        }
    }


    //모든 텍스트필드 초기화
    private void setClearField() {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof TextField) {
                ((TextField) component).setText("");
            }
        }
        accountNumberTF.requestFocus();

    }
}


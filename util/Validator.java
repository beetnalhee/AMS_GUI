package com.ezen.ams.util;

// Validator.isText  등 으로 실행 가능

public class Validator {

    /**
     * 데이터 유효성 검증을 위한 유틸리티 클래스 ..
     * @param value 검증하고자 하는 문자열
     * @return 값이 있을 경우 true, 없을경우 false
     */

    public static boolean isText(String value) {
        if (value != null && value.trim().length() != 0) {
            return true;
        }
        return false;
    }

    public static boolean isId(String inputId) {
        if (inputId == null) {
            return false;
        }
        for (int i = 0; i < inputId.length(); i++) {
            char ch = inputId.charAt(i);
            if (!Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
                return false;
            }

        }return true;
    }


    public static boolean isNumber (String value){
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }

        }
        return true;
    }

    // 계좌번호는 숫자와 하이픈으로만 이루어져야 함
    public static boolean isAccountNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (!Character.isDigit(ch) && ch != '-') {
                return false;
            }
        }
        return true;
    }
}


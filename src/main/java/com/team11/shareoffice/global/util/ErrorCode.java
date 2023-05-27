package com.team11.shareoffice.global.util;

import lombok.Getter;

@Getter
public enum ErrorCode {
    EXIST_EMAIL("ExistEmail", "이미 등록된 이메일 입니다."),
    EXIST_NICKNAME("ExistNickname", "이미 등록된 닉네임 입니다."),
    INVALID_NICKNAME_PATTERN ("InvalidNicknamePattern", "닉네임은 최소 2~10글자여야 합니다."),
    NOT_SAME_PASSWORD("NotSamePassword", "비밀번호가 서로 일치하지 않습니다."),
    INVALID_PASSWORD_PATTERN ("InvalidPasswordPattern", "비밀번호는 8-15자리, 최소 하나의 영어 대소문자, 숫자, 특수문자(@$!%*?&()_)를 포함해야 합니다."),
    INVALID_EMAIL_PATTERN ("InvalidEmailPattern", "유효하지 않은 이메일 형식입니다."),
    WRONG_EMAIL_CODE ("WrongEmailCode", "인증 코드가 일치하지 않습니다"),
    WRONG_EMAIL ("WrongEmail", "인증을 요청한 이메일이 아닙니다."),
    NOT_EXIST_EMAIL("NotExistEmail", "등록되지 않은 이메일입니다."),
    WRONG_PASSWORD("WrongPassword", "비밀번호를 확인해주세요");


    String errorCode;
    String message;

    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
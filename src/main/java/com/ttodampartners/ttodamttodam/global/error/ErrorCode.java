package com.ttodampartners.ttodamttodam.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
  /*
  User Exception
   */
  NOT_FOUND_EMAIL("등록되지 않은 이메일입니다."),
  EXISTS_EMAIL("이미 등록된 이메일입니다."),
  EXISTS_PHONE("이미 등록된 휴대폰 번호입니다."),
  EXISTS_NICKNAME("이미 등록된 닉네임입니다."),
  NOT_MATCH_PASSWORD("비밀번호가 일치하지 않습니다."),

  /*
  Mail Exception
   */
  NOT_CERTIFIED("메일 인증을 진행해 주세요."),
  AUTH_KEY_MISMATCH("인증키가 일치하지 않습니다."),
  MAIL_CREATION_ERROR("메일을 생성하는 중 오류가 발생했습니다.")
  ;

  private final String description;

}

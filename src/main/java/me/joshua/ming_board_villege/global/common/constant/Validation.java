package me.joshua.ming_board_villege.global.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validation {

    public final static String MEMBER_EMAIL_REGEXP = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public final static String MEMBER_PASSWORD_REGEXP = "(?=.*[A-Za-z])(?=.*[0-9]).{8,15}";

}

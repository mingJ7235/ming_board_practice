package me.joshua.ming_board_villege.domain.member.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.joshua.ming_board_villege.global.common.enumerate.Gender;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static me.joshua.ming_board_villege.global.common.constant.Validation.MEMBER_EMAIL_REGEXP;
import static me.joshua.ming_board_villege.global.common.constant.Validation.MEMBER_PASSWORD_REGEXP;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDto {

    //회원가입 DTO
    @Getter
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Signup {

        @NotBlank
        @Size(min = 1, max = 20)
        private String name;

        @NotBlank
        @Email (regexp = MEMBER_EMAIL_REGEXP)
        private String email;

        @NotBlank
        @Pattern(regexp = MEMBER_PASSWORD_REGEXP)
        private String password;

        private Long age;

        private Gender gender;
    }
}

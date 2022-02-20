package me.joshua.ming_board_villege.domain.member.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.joshua.ming_board_villege.global.common.enumerate.Gender;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.validation.constraints.*;

import static me.joshua.ming_board_villege.global.common.constant.Validation.MEMBER_EMAIL_REGEXP;
import static me.joshua.ming_board_villege.global.common.constant.Validation.MEMBER_PASSWORD_REGEXP;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRequestDto {

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

        @NotNull
        private Long age;

        @NotNull
        private Gender gender;

        @NotNull
        private MBTI mbti;
    }
}

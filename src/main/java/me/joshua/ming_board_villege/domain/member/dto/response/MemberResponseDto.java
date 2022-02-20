package me.joshua.ming_board_villege.domain.member.dto.response;

import lombok.*;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.global.common.enumerate.Gender;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.validation.constraints.NotNull;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class MemberResponseDto {

    @Getter
    @Builder (access = AccessLevel.PRIVATE)
    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Response {

        private Long id;

        private String name;

        private String email;

        private Long age;

        private Gender gender;

        private MBTI mbti;

        public static Response from (@NotNull Member member) {
            return Response.builder()
                    .id(member.getId())
                    .name(member.getName())
                    .email(member.getEmail())
                    .age(member.getAge())
                    .gender(member.getGender())
                    .mbti(member.getMbti())
                    .build();
        }
    }
}

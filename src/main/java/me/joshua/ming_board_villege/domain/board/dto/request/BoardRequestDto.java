package me.joshua.ming_board_villege.domain.board.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.joshua.ming_board_villege.domain.member.entity.Member;

import java.time.LocalDateTime;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class BoardRequestDto {

    @Getter
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Create {

        private String subject;

        private String content;

        private LocalDateTime createdDate;

        private Member writer;

    }
}

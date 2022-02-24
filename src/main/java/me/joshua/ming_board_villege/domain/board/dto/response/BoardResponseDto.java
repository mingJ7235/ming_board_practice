package me.joshua.ming_board_villege.domain.board.dto.response;

import lombok.*;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.validation.constraints.NotNull;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class BoardResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Response {

        private Long id;

        private String subject;

        private String content;

        private MBTI mbti;

        public Response from (final @NotNull Board board) {
            return Response.builder().build();
        }

    }
}

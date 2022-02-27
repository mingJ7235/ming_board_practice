package me.joshua.ming_board_villege.domain.reply.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.domain.member.entity.Member;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class ReplyRequestDto {

    @Getter
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Create {

        private String content;

        private Member writer;

        private Board board;

    }

}

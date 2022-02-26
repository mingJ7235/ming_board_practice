package me.joshua.ming_board_villege.domain.reply.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class ReplyRequestDto {

    @Getter
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Create {

        private String content;

        private Long writerId;

    }

}

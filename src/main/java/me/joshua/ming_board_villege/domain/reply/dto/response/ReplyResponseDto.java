package me.joshua.ming_board_villege.domain.reply.dto.response;

import lombok.*;
import me.joshua.ming_board_villege.domain.reply.entity.Reply;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class ReplyResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor (access = AccessLevel.PRIVATE)
    @NoArgsConstructor (access = AccessLevel.PRIVATE)
    public static class Response {
        private Long id;

        private Long memberId;

        private String content;

        private LocalDateTime createdTime;

        private LocalDateTime updatedTime;

        public static Response from (final @NotNull Reply reply) {
            return Response.builder()
                    .id(reply.getId())
                    .memberId(reply.getWriter().getId())
                    .content(reply.getContent())
                    .createdTime(reply.getCreatedTime())
                    .updatedTime(reply.getUpdatedTime())
                    .build();
        }
    }

}

package me.joshua.ming_board_villege.domain.reply.entity;

import lombok.*;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.domain.reply.dto.request.ReplyRequestDto;
import me.joshua.ming_board_villege.domain.reply.dto.response.ReplyResponseDto;
import me.joshua.ming_board_villege.global.common.base.BaseTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class Reply extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String content;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn
    private Member writer;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn
    private Board board;

    public static Reply from (final ReplyRequestDto.@NotNull Create request) {
        return Reply.builder()
                .content(request.getContent())
                .writer(request.getWriter())
                .board(request.getBoard())
                .build();
    }

}

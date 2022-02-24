package me.joshua.ming_board_villege.domain.board.entity;

import lombok.*;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.persistence.*;

@Entity
@Getter
@Setter (AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String subject;

    @Column (nullable = false)
    private String content;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private MBTI mbti;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "member_id")
    private Member owner;
}

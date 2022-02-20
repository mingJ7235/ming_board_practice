package me.joshua.ming_board_villege.domain.board.entity;

import lombok.*;
import me.joshua.ming_board_villege.domain.member.entity.Member;

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

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "member_id")
    private Member owner;
}

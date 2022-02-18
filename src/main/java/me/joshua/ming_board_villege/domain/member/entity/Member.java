package me.joshua.ming_board_villege.domain.member.entity;

import lombok.*;
import me.joshua.ming_board_villege.global.common.base.BaseTime;
import me.joshua.ming_board_villege.global.common.enumerate.Gender;

import javax.persistence.*;

@Getter
@Entity
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor (access = AccessLevel.PRIVATE)
public class Member extends BaseTime {

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String password;

    private Long age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}

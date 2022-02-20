package me.joshua.ming_board_villege.domain.member.entity;

import lombok.*;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.global.common.base.BaseTime;
import me.joshua.ming_board_villege.global.common.enumerate.Gender;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter (AccessLevel.PRIVATE)
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

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private MBTI mbti;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Board> boardList;

    public static Member toEntity (final MemberRequestDto.@NotNull Signup request) {
        return Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .age(request.getAge())
                .gender(request.getGender())
                .mbti(request.getMbti())
                .build();
    }

    public void update (final MemberRequestDto.@NotNull Update request) {

        if(StringUtils.hasText(request.getName()))
            this.setName(request.getName());

        if(request.getAge() != null)
            this.setAge(request.getAge());

        if(request.getGender() != null)
            this.setGender(request.getGender());

        if(request.getMbti() != null)
            this.setMbti(request.getMbti());
    }

}

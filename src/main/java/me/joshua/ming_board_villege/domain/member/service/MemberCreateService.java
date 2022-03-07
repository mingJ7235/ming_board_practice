package me.joshua.ming_board_villege.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.domain.member.dto.response.MemberResponseDto;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.domain.member.service.core.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberCreateService {

    private final MemberService memberService;

    @Transactional
    public MemberResponseDto.Response signup (final MemberRequestDto.@NotNull Signup request) {

        if (checkEmailDuplication(request.getEmail()))
            throw new RuntimeException(); //FIXME : Exception 정리해야함

        return MemberResponseDto.Response.from(memberService.signUp(request));
    }


    //이메일 중복 검증 로직
    private boolean checkEmailDuplication (final @NotBlank String email) {
        return memberService.existsByEmail(email);
    }

}

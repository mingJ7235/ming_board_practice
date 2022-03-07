package me.joshua.ming_board_villege.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.domain.member.dto.response.MemberResponseDto;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.domain.member.repository.MemberRepository;
import me.joshua.ming_board_villege.domain.member.service.core.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFindService {

    private final MemberRepository memberRepository;

    private final MemberService memberService;

    @Transactional (readOnly = true)
    public MemberResponseDto.Response findById(@NotNull final Long id) {
        return MemberResponseDto.Response
                .from(memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find member id")));
    }

    @Transactional (readOnly = true)
    public List<MemberResponseDto.Response> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto.Response::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public MemberResponseDto.Response updateById(@NotNull final Long id, @NotNull final MemberRequestDto.Update request) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found id"));
        member.update(request);

        return MemberResponseDto.Response.from(member);
    }

}

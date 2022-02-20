package me.joshua.ming_board_villege.domain.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.domain.member.dto.response.MemberResponseDto;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto.Response signup (@NotNull MemberRequestDto.Signup request) {
        return MemberResponseDto.Response.from(memberRepository.save(Member.toEntity(request)));
    }

    public MemberResponseDto.Response findById(@NotNull final Long id) {
        return MemberResponseDto.Response
                .from(memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find member id")));
    }

    public List<MemberResponseDto.Response> findAll() {
        return memberRepository.findAll()
                .stream()
                .map(MemberResponseDto.Response::from)
                .collect(Collectors.toList());
    }

}

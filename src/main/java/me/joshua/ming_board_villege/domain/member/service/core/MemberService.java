package me.joshua.ming_board_villege.domain.member.service.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.entity.Member;
import me.joshua.ming_board_villege.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public Member findById (final @NotNull Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not find id"));
    }
}

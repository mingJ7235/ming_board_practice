package me.joshua.ming_board_villege.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.board.dto.response.BoardResponseDto;
import me.joshua.ming_board_villege.domain.board.service.core.BoardService;
import me.joshua.ming_board_villege.domain.member.service.core.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardCreateService {

    private final BoardService boardService;

    private final MemberService memberService;
    @Transactional
    public BoardResponseDto.Response create(final @NotNull Long memberId, final BoardRequestDto.@NotNull Create request) {
        return BoardResponseDto.Response.from(boardService.create(request));
    }
}

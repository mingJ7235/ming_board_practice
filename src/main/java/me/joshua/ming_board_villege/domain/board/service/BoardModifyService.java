package me.joshua.ming_board_villege.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.board.dto.response.BoardResponseDto;
import me.joshua.ming_board_villege.domain.board.service.core.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardModifyService {

    private final BoardService boardService;

    public BoardResponseDto.Response update (final @NotNull Long boardId,
                                             final @NotNull BoardRequestDto.@NotNull Update request) {
        return BoardResponseDto.Response.from(boardService.update(boardId, request));
    }

}

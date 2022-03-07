package me.joshua.ming_board_villege.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.service.core.BoardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardDeleteService {

    private final BoardService boardService;

    public void deleteById (final @NotNull Long boardId) {
        boardService.deleteById(boardId);
    }
}

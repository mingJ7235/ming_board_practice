package me.joshua.ming_board_villege.domain.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.board.dto.response.BoardResponseDto;
import me.joshua.ming_board_villege.domain.board.service.BoardCreateService;
import me.joshua.ming_board_villege.domain.board.service.core.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final BoardCreateService createService;

    @PostMapping ("/boards")
    public ResponseEntity<BoardResponseDto.Response> create (final @NotNull Long memberId,
                                                             final BoardRequestDto.@NotNull Create request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createService.create(memberId, request));
    }
}

package me.joshua.ming_board_villege.domain.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.response.BoardResponseDto;
import me.joshua.ming_board_villege.domain.board.service.core.BoardService;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional (readOnly = true)
@RequiredArgsConstructor
public class BoardFindService {

    private final BoardService boardService;

    public BoardResponseDto.Response findById (final @NotNull Long id) {
        return BoardResponseDto.Response.from(boardService.findById(id));
    }

    public List<BoardResponseDto.Response> findAllByMbti (final @NotNull MBTI mbti) {
        return boardService.findAllByMbti(mbti)
                .stream()
                .map(BoardResponseDto.Response::from)
                .collect(Collectors.toList());
    }
}

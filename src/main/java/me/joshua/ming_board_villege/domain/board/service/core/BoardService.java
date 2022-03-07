package me.joshua.ming_board_villege.domain.board.service.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.domain.board.repository.BoardRepository;
import me.joshua.ming_board_villege.domain.board.repository.QueryBoardRepository;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    private final QueryBoardRepository queryBoardRepository;

    public Board create (final BoardRequestDto.@NotNull Create request) {
        return boardRepository.save(Board.toEntity(request));
    }

    @Transactional (readOnly = true)
    public Board findById (final @NotNull Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found board id"));
    }

    @Transactional (readOnly = true)
    public List<Board> findAllByMbti (final @NotNull MBTI mbti) {
        return queryBoardRepository.findAllByMbti(mbti);
    }

}

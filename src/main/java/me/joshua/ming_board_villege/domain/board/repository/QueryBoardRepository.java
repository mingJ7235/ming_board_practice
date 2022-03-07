package me.joshua.ming_board_villege.domain.board.repository;

import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface QueryBoardRepository {

    List<Board> findAllByMbti (final @NotNull MBTI mbti);

}

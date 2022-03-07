package me.joshua.ming_board_villege.domain.board.repository;

import me.joshua.ming_board_villege.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, QueryBoardRepository{

}

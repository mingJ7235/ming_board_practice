package me.joshua.ming_board_villege.domain.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.joshua.ming_board_villege.domain.board.entity.Board;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;

import java.util.List;

import static me.joshua.ming_board_villege.domain.board.entity.QBoard.board;

@RequiredArgsConstructor
public class QueryBoardRepositoryImpl implements QueryBoardRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findAllByMbti(final MBTI mbti) {
        return queryFactory
                .select(board)
                .from(board)
                .where(board.mbti.eq(mbti))
                .fetch();
    }

}

package me.joshua.ming_board_villege.domain.reply.repository;

import me.joshua.ming_board_villege.domain.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByBoardId (final @NotNull Long boardId);

}

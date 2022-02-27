package me.joshua.ming_board_villege.domain.reply.service.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.reply.entity.Reply;
import me.joshua.ming_board_villege.domain.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public Reply save (final @NotNull Reply reply) {
        return replyRepository.save(reply);
    }

    @Transactional (readOnly = true)
    public Reply findById(final @NotNull Long id) {
        return replyRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("not found reply id"));
    }

}

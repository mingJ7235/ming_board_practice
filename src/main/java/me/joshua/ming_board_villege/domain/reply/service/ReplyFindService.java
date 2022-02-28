package me.joshua.ming_board_villege.domain.reply.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.reply.dto.response.ReplyResponseDto;
import me.joshua.ming_board_villege.domain.reply.service.core.ReplyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ReplyFindService {

    private final ReplyService replyService;

    @Transactional (readOnly = true)
    public ReplyResponseDto.Response findById (final @NotNull Long id) {
        return ReplyResponseDto.Response.from(replyService.findById(id));
    }

    @Transactional (readOnly = true)
    public List<ReplyResponseDto.Response> findAllByBoardId (final @NotNull Long boardId) {
        return replyService.findAllByBoardId(boardId)
                .stream()
                .map(ReplyResponseDto.Response::from)
                .collect(Collectors.toList());
    }
}

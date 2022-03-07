package me.joshua.ming_board_villege.domain.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.board.dto.request.BoardRequestDto;
import me.joshua.ming_board_villege.domain.board.dto.response.BoardResponseDto;
import me.joshua.ming_board_villege.domain.board.service.BoardCreateService;
import me.joshua.ming_board_villege.domain.board.service.BoardFindService;
import me.joshua.ming_board_villege.domain.board.service.BoardModifyService;
import me.joshua.ming_board_villege.global.common.enumerate.MBTI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardCreateService createService;

    private final BoardFindService findService;

    private final BoardModifyService modifyService;

    //게시판 등록
    @PostMapping ("/boards")
    public ResponseEntity<BoardResponseDto.Response> create (final @NotNull Long memberId,
                                                             final BoardRequestDto.@NotNull Create request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createService.create(memberId, request));
    }

    //게시판 단건 조회
    @GetMapping ("/boards/{id}")
    public ResponseEntity<BoardResponseDto.Response> findById (final @PathVariable Long id) {
        return ResponseEntity
                .ok(findService.findById(id));
    }

    //게시판 mbti 별 리스트 조회
    //FIXME : requestParam -> Enum 과 String 의 매핑
    @GetMapping ("/boards")
    public ResponseEntity<List<BoardResponseDto.Response>> findAllByMbti (final @RequestParam MBTI mbti) {
        return ResponseEntity
                .ok(findService.findAllByMbti(mbti));
    }

    //게시판 업데이트
    @PutMapping ("/boards/{id}")
    public ResponseEntity<BoardResponseDto.Response> updateById (final @PathVariable Long id,
                                                                 final BoardRequestDto.@NotNull Update request) {
        return ResponseEntity
                .ok(modifyService.update(id, request));
    }
}

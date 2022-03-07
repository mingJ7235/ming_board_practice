package me.joshua.ming_board_villege.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.domain.member.dto.response.MemberResponseDto;
import me.joshua.ming_board_villege.domain.member.service.MemberCreateService;
import me.joshua.ming_board_villege.domain.member.service.MemberFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberFindService findService;

    private final MemberCreateService createService;

    //회원가입
    @PostMapping ("/members")
    public ResponseEntity<MemberResponseDto.Response> signup (@RequestBody MemberRequestDto.Signup request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createService.signup(request));
    }

    //멤버 단건 정보 조회
    @GetMapping ("/members/{id}")
    public ResponseEntity<MemberResponseDto.Response> findById (@PathVariable Long id) {
        return ResponseEntity
                .ok(findService.findById(id));
    }

    //멤버 전체 조회
    @GetMapping ("/members")
    public ResponseEntity<List<MemberResponseDto.Response>> findAll () {
        return ResponseEntity
                .ok(findService.findAll());
    }

    //내정보 수정
    @PatchMapping ("/members/{id}")
    public ResponseEntity<MemberResponseDto.Response> updateById (@PathVariable Long id,
                                                                  @RequestBody MemberRequestDto.Update request) {
        //검증 로직
        return ResponseEntity
                .ok(findService.updateById(id, request));
    }


}

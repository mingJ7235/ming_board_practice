package me.joshua.ming_board_villege.domain.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.joshua.ming_board_villege.domain.member.dto.request.MemberRequestDto;
import me.joshua.ming_board_villege.domain.member.dto.response.MemberResponseDto;
import me.joshua.ming_board_villege.domain.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
    @PostMapping ("/members")
    public ResponseEntity<MemberResponseDto.Response> signup (@RequestBody MemberRequestDto.Signup request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(memberService.signup(request));
    }


}

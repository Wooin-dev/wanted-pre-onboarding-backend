package com.wooin.wantedinternship.user.controller;

import com.wooin.wantedinternship.common.dto.ApiResponseDto;
import com.wooin.wantedinternship.user.dto.SignupRequestDto;
import com.wooin.wantedinternship.user.dto.UserInfoResponseDto;
import com.wooin.wantedinternship.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    //멤버선언
    private final UserService userService;

    //생성자. 빈 주입.
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //메소드
    @PostMapping("/users/sign-up")
    @Operation(summary = "유저 회원가입", description = "ResponseDto를 통해 가입할 유저정보를 받아옵니다.")
    public ResponseEntity<ApiResponseDto> signup(
            @Valid @RequestBody SignupRequestDto requestDto
    ) {
            UserInfoResponseDto responseDto = userService.signup(requestDto);
            return ResponseEntity.ok()
                    .body(new ApiResponseDto(
                            HttpStatus.OK.value(),
                            responseDto.getUsername()+"님의 회원가입이 완료되었습니다.")
                    );
    }
}

package com.wooin.wantedinternship.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequestDto {
    @NotBlank
    @Size(min = 4, max = 10, message = "최소 4글자에서 최대 10글자까지 입력 가능합니다.")
    @Pattern(regexp = "^[a-z0-9]*$", message = "알파벳 소문자와 숫자만 입력 가능합니다.")
    private String username;
}

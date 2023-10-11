package com.wooin.wantedinternship.user.dto;

import com.wooin.wantedinternship.user.entity.User;
import lombok.Getter;

@Getter
public class UserInfoResponseDto {
    private String username;

    public UserInfoResponseDto(User user) {
        this.username = user.getUsername();
    }
}

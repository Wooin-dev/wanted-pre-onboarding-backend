package com.wooin.wantedinternship.apply.dto;

import com.wooin.wantedinternship.apply.entity.Apply;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApplyResponseDto {

    private Long userId;
    private Long recruitId;
    private String position;
    private String skill;
    private String companyName;
    private LocalDateTime applyTime;


    public ApplyResponseDto(Apply apply) {
        this.userId = apply.getUser().getId();
        this.recruitId = apply.getRecruit().getId();
        this.position = apply.getRecruit().getPosition();
        this.skill = apply.getRecruit().getSkill();
        this.companyName = apply.getRecruit().getCompany().getName();
        this.applyTime = apply.getCreatedAt();
    }
}

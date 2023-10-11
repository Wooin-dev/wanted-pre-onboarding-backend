package com.wooin.wantedinternship.recruit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecruitRequestDto {
    private String position;
    private String contents;
    private Integer reward;
    private String skill;
    private Long companyId;
}

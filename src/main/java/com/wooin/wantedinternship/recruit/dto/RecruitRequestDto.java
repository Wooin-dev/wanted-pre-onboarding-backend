package com.wooin.wantedinternship.recruit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecruitRequestDto {
    private String position;
    private Integer reward;
    private String contents;
    private String skill;
    private Long companyId;
}

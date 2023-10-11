package com.wooin.wantedinternship.recruit.dto;

import com.wooin.wantedinternship.recruit.entity.Recruit;
import lombok.Getter;

@Getter
public class RecruitOnBoardResponseDto {

    //채용공고 리스트에 사용되는 dto

    private Long id;
    private String position;
    private Integer reward;
    private String skill;
    private String companyName;
    private String region;
    private String national;

    public RecruitOnBoardResponseDto(Recruit recruit) {
        this.id = recruit.getId();
        this.position = recruit.getPosition();
        this.reward = recruit.getReward();
        this.skill = recruit.getSkill();
        this.companyName = recruit.getCompany().getName();
        this.region = recruit.getCompany().getRegion();
        this.national = recruit.getCompany().getNational();
    }
}

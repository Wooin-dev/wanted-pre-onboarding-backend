package com.wooin.wantedinternship.recruit.dto;

import com.wooin.wantedinternship.recruit.entity.Recruit;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RecruitDetailResponseDto {

    //채용공고 단건 상세페이지 응답에 사용되는 Dto

    //멤버 선언
    private Long id;
    private String position;
    private Integer reward;
    private String contents;
    private String skill;
    private String companyName;
    private String region;
    private String national;

    private List<RecruitOnBoardResponseDto> linkedRecruitList;


    //생성자
    public RecruitDetailResponseDto(Recruit recruit) {
        this.id = recruit.getId();
        this.position = recruit.getPosition();
        this.reward = recruit.getReward();
        this.contents = recruit.getContents();
        this.skill = recruit.getSkill();
        this.companyName = recruit.getCompany().getName();
        this.region = recruit.getCompany().getRegion();
        this.national = recruit.getCompany().getNational();

        this.linkedRecruitList = recruit.getCompany().getRecruits()
                .stream()
                .filter(recruitment -> !recruitment.getId().equals(recruit.getId()))
                .map(RecruitOnBoardResponseDto::new)
                .toList();
    }
}

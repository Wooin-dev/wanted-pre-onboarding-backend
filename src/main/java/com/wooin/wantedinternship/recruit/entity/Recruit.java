package com.wooin.wantedinternship.recruit.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.recruit.dto.RecruitRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recruit extends Timestamped {

    @Id
    @Column(name = "recruit_id")
    private Long id;

    private String position;

    private Integer reward;

    private String contents;

    private String skill;


    //연관관계 매핑

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    //생성자
    @Builder
    public Recruit(String position, Integer reward, String contents, String skill, Company company) {
        this.position = position;
        this.reward = reward;
        this.contents = contents;
        this.skill = skill;
        this.company = company;
    }

    public Recruit(RecruitRequestDto requestDto, Company company) {
        this.position = requestDto.getPosition();
        this.reward = requestDto.getReward();
        this.contents = requestDto.getContents();
        this.skill = requestDto.getSkill();
        this.company = company;
    }


    //메소드
    public Recruit modifyRecruit(RecruitRequestDto requestDto) {
        this.position = requestDto.getPosition();
        this.reward = requestDto.getReward();
        this.contents = requestDto.getContents();
        this.skill = requestDto.getSkill();

        return this;
    }
}

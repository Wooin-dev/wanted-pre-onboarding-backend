package com.wooin.wantedinternship.company.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends Timestamped {

    //멤버 선언
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;
    private String name;
    private String region;
    private String national;


    //양방향 매핑관계
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Recruit> recruits = new ArrayList<>();


    //생성자
    public Company(CompanyRequestDto requestDto) {
        this.name = requestDto.getName();
        this.region = requestDto.getRegion();
        this.national = requestDto.getNational();
    }

    public Company update(CompanyRequestDto requestDto) {
        this.name = requestDto.getName();
        this.region = requestDto.getRegion();
        this.national = requestDto.getNational();

        return this;
    }
}

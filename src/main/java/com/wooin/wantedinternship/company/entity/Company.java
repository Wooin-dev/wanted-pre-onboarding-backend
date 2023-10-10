package com.wooin.wantedinternship.company.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

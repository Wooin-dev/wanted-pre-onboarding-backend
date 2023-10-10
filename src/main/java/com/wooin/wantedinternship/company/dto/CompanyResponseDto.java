package com.wooin.wantedinternship.company.dto;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.company.entity.Company;
import lombok.Getter;

@Getter
public class CompanyResponseDto {

    //멤버 선언
    private Long id;
    private String name;
    private String region;
    private String national;


    //생성자
    public CompanyResponseDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.region = company.getRegion();
        this.national = company.getNational();
    }
}

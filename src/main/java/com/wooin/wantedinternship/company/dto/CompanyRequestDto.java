package com.wooin.wantedinternship.company.dto;

import com.wooin.wantedinternship.common.entity.Timestamped;
import lombok.Getter;

@Getter
public class CompanyRequestDto extends Timestamped {
    private String name;
    private String region;
    private String national;
}

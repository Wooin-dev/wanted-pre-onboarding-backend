package com.wooin.wantedinternship.company.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends Timestamped {

    @Id
    @Column(name = "company_id")
    private Long id;

    private String name;

    private String region;

    private String national;
}

package com.wooin.wantedinternship.apply.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Apply extends Timestamped {

    @Id
    @Column(name = "apply_id")
    private Long id;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

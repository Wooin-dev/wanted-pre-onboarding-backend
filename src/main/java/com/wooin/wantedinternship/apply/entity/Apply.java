package com.wooin.wantedinternship.apply.entity;

import com.wooin.wantedinternship.common.entity.Timestamped;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import com.wooin.wantedinternship.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Apply extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "recruit_id")
    private Recruit recruit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //생성자
    public Apply(Recruit recruit, User user) {
        this.recruit = recruit;
        this.user = user;
    }
}

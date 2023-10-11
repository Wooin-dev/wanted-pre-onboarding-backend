package com.wooin.wantedinternship.apply.repository;

import com.wooin.wantedinternship.apply.entity.Apply;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import com.wooin.wantedinternship.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {
    void deleteByRecruitAndUser(Recruit recruit, User user);
    boolean existsByRecruitAndUser(Recruit recruit, User user);
}

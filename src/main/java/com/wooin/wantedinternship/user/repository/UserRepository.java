package com.wooin.wantedinternship.user.repository;

import com.wooin.wantedinternship.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
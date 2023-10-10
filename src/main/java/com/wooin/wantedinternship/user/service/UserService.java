package com.wooin.wantedinternship.user.service;

import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.user.entity.User;
import com.wooin.wantedinternship.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("해당 유저를 찾을 수 없습니다."));
        return foundUser;
    }
}

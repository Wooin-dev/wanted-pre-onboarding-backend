package com.wooin.wantedinternship.user.service;

import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.user.dto.SignupRequestDto;
import com.wooin.wantedinternship.user.dto.UserInfoResponseDto;
import com.wooin.wantedinternship.user.entity.User;
import com.wooin.wantedinternship.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //멤버 선언
    private final UserRepository userRepository;

    //생성자. 빈 주입.
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    //메소드
    public UserInfoResponseDto signup(SignupRequestDto requestDto) {
        User newUser = new User(requestDto);
        User savedUser = userRepository.save(newUser);

        return new UserInfoResponseDto(savedUser);
    }

    public User findUserById(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(()-> new NotFoundException("해당 유저를 찾을 수 없습니다."));
        return foundUser;
    }
}

package com.wooin.wantedinternship.apply.service;

import com.wooin.wantedinternship.apply.dto.ApplyResponseDto;
import com.wooin.wantedinternship.apply.entity.Apply;
import com.wooin.wantedinternship.apply.repository.ApplyRepository;
import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import com.wooin.wantedinternship.recruit.service.RecruitService;
import com.wooin.wantedinternship.user.entity.User;
import com.wooin.wantedinternship.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplyService {

    //멤버 선언
    private final ApplyRepository applyRepository;
    private final RecruitService recruitService;
    private final UserService userService;

    //생성자. 빈 주입.
    public ApplyService(ApplyRepository applyRepository, RecruitService recruitService, UserService userService) {
        this.applyRepository = applyRepository;
        this.recruitService = recruitService;
        this.userService = userService;
    }


    //메소드
    @Transactional
    public ApplyResponseDto createApply(Long recruitId, Long userId) {

        Recruit foundRecruit = recruitService.findRecruitById(recruitId);
        User foundUser = userService.findUserById(userId);

        //중복체크
        checkExistedApply(foundRecruit, foundUser);

        Apply createdApply = new Apply(foundRecruit, foundUser);
        Apply savedApply = applyRepository.save(createdApply);

        return new ApplyResponseDto(savedApply);
    }

    @Transactional(readOnly = true)
    public ApplyResponseDto getApplyOne(Long applyId) {

        Apply foundApply = findApplyById(applyId);
        return new ApplyResponseDto(foundApply);
    }


    @Transactional(readOnly = true)
    public Apply findApplyById(Long applyId) {
        return applyRepository.findById(applyId).orElseThrow(()-> new NotFoundException("해당 채용지원을 찾을 수 없습니다."));
    }


    //private 메소드
    private void checkExistedApply(Recruit foundRecruit, User foundUser) {
        if (applyRepository.existsByRecruitAndUser(foundRecruit, foundUser)){
            throw new IllegalArgumentException("해당 채용공고에 이미 지원했습니다.");
        }
    }
}

package com.wooin.wantedinternship.recruit.service;

import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.company.service.CompanyService;
import com.wooin.wantedinternship.recruit.dto.RecruitDetailResponseDto;
import com.wooin.wantedinternship.recruit.dto.RecruitRequestDto;
import com.wooin.wantedinternship.recruit.dto.RecruitOnBoardResponseDto;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import com.wooin.wantedinternship.recruit.repository.RecruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecruitService {
    //멤버선언
    private final RecruitRepository recruitRepository;
    private final CompanyService companyService;

    //생성자. 빈 주입
    public RecruitService(RecruitRepository recruitRepository, CompanyService companyService) {
        this.recruitRepository = recruitRepository;
        this.companyService = companyService;
    }


    //메소드
    @Transactional(readOnly = true)
    public List<RecruitOnBoardResponseDto> getRecruitList() {

        List<Recruit> recruits = recruitRepository.findAll();
        return recruits.stream().map(RecruitOnBoardResponseDto::new).toList();
    }

    @Transactional(readOnly = true)
    public RecruitDetailResponseDto getRecruitOne(Long recruitId) {

        Recruit selectedRecruit = findRecruitById(recruitId);
        return new RecruitDetailResponseDto(selectedRecruit);
    }

    @Transactional
    public RecruitOnBoardResponseDto createRecruit(RecruitRequestDto requestDto) {

        Company foundCompany = companyService.findCompanyById(requestDto.getCompanyId());

        Recruit createdRecruit = new Recruit(requestDto, foundCompany);
        Recruit savedRecruit = recruitRepository.save(createdRecruit);

        return new RecruitOnBoardResponseDto(savedRecruit);
    }

    @Transactional
    public RecruitOnBoardResponseDto modifyRecruit(RecruitRequestDto requestDto, Long recruitId) {

        Recruit foundRecruit = findRecruitById(recruitId);
        Recruit modifiedRecruit = foundRecruit.modifyRecruit(requestDto);
        return new RecruitOnBoardResponseDto(modifiedRecruit);
    }

    @Transactional
    public void deleteRecruit(Long recruitId) {

        recruitRepository.deleteById(recruitId);
    }


    public Recruit findRecruitById(Long recruitId) {
        return recruitRepository.findById(recruitId).orElseThrow(() -> new NotFoundException("채용공고를 찾을 수 없습니다."));
    }
}

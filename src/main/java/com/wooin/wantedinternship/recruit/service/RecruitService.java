package com.wooin.wantedinternship.recruit.service;

import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.company.repository.CompanyRepository;
import com.wooin.wantedinternship.recruit.dto.RecruitRequestDto;
import com.wooin.wantedinternship.recruit.dto.RecruitResponseDto;
import com.wooin.wantedinternship.recruit.entity.Recruit;
import com.wooin.wantedinternship.recruit.repository.RecruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecruitService {
    //멤버선언
    private final RecruitRepository recruitRepository;
    private final CompanyRepository companyRepository;

    //생성자. 빈 주입
    public RecruitService(RecruitRepository recruitRepository, CompanyRepository companyRepository) {
        this.recruitRepository = recruitRepository;
        this.companyRepository = companyRepository;
    }


    //메소드
    @Transactional(readOnly = true)
    public RecruitResponseDto selectRecruitOne(Long recruitId) {

        Recruit selectedRecruit = selectRecruitById(recruitId);
        return new RecruitResponseDto(selectedRecruit);
    }

    @Transactional(readOnly = true)
    public List<RecruitResponseDto> selectRecruitList() {

        List<Recruit> recruits = recruitRepository.findAll();
        return recruits.stream().map(RecruitResponseDto::new).toList();
    }

    @Transactional
    public RecruitResponseDto createRecruit(RecruitRequestDto requestDto, Long companyId) {

        Company foundCompany = findCompanyById(companyId);

        Recruit createdRecruit = new Recruit(requestDto, foundCompany);
        Recruit savedRecruit = recruitRepository.save(createdRecruit);

        return new RecruitResponseDto(savedRecruit);
    }

    @Transactional
    public RecruitResponseDto modifyRecruit(RecruitRequestDto requestDto, Long recruitId) {

        Recruit foundRecruit = findRecruitById(recruitId);
        Recruit modifiedRecruit = foundRecruit.modifyRecruit(requestDto);
        return new RecruitResponseDto(modifiedRecruit);
    }

    @Transactional
    public void deleteRecruit(Long recruitId) {

        recruitRepository.deleteById(recruitId);
    }



    //private 메소드

    private Recruit selectRecruitById(Long recruitId) {
        return recruitRepository.findById(recruitId).orElseThrow(() -> new NotFoundException("해당 채용공고를 찾을 수 없습니다."));
    }

    private Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new NotFoundException("회사 정보를 찾을 수 없습니다."));
    }

    private Recruit findRecruitById(Long recruitId) {
        return recruitRepository.findById(recruitId).orElseThrow(() -> new NotFoundException("채용공고를 찾을 수 없습니다."));
    }
}

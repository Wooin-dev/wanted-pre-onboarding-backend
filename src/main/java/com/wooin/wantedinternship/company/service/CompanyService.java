package com.wooin.wantedinternship.company.service;

import com.wooin.wantedinternship.common.exception.NotFoundException;
import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import com.wooin.wantedinternship.company.dto.CompanyResponseDto;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    //멤버 선언
    private final CompanyRepository companyRepository;

    //생성자. 빈주입.
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    //메소드
    @Transactional
    public CompanyResponseDto createCompany(CompanyRequestDto requestDto) {

        Company createdCompany = new Company(requestDto);
        Company savedCompany = companyRepository.save(createdCompany);

        return new CompanyResponseDto(savedCompany);
    }

    @Transactional(readOnly = true)
    public List<CompanyResponseDto> getCompanyList() {

        List<Company> companies = companyRepository.findAll();
        return companies.stream().map(CompanyResponseDto::new).toList();
    }


    @Transactional(readOnly = true)
    public CompanyResponseDto getCompanyOne(Long companyId) {

        Company foundCompany = findCompanyById(companyId);
        return new CompanyResponseDto(foundCompany);
    }


    @Transactional
    public CompanyResponseDto modifyCompany(Long companyId, CompanyRequestDto requestDto) {

        Company foundCompany = findCompanyById(companyId);
        Company updatedCompany = foundCompany.update(requestDto);

        return new CompanyResponseDto(updatedCompany);
    }

    @Transactional
    public void deleteCompany(Long companyId) {

        companyRepository.deleteById(companyId);
    }


    public Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new NotFoundException("회사 정보를 찾을 수 없습니다."));
    }

}

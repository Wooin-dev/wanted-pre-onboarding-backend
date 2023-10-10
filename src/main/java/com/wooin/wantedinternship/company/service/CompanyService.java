package com.wooin.wantedinternship.company.service;

import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import com.wooin.wantedinternship.company.dto.CompanyResponseDto;
import com.wooin.wantedinternship.company.entity.Company;
import com.wooin.wantedinternship.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    public CompanyResponseDto createCompany(CompanyRequestDto requestDto) {

        Company createdCompany = new Company(requestDto);
        Company savedCompany = companyRepository.save(createdCompany);

        return new CompanyResponseDto(savedCompany);
    }
}

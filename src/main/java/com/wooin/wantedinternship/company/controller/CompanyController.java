package com.wooin.wantedinternship.company.controller;


import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import com.wooin.wantedinternship.company.dto.CompanyResponseDto;
import com.wooin.wantedinternship.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompanyController {
    //멤버 선언
    private final CompanyService companyService;

    //빈 주입
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //메소드
    @Operation(summary = "회사정보 생성")
    @PostMapping("/companies")
    public ResponseEntity<CompanyResponseDto> createCompany(
            @RequestBody CompanyRequestDto requestDto
    ) {
        CompanyResponseDto responseDto = companyService.createCompany(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}

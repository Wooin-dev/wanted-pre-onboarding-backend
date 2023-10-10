package com.wooin.wantedinternship.company.controller;


import com.wooin.wantedinternship.common.dto.ApiResponseDto;
import com.wooin.wantedinternship.company.dto.CompanyRequestDto;
import com.wooin.wantedinternship.company.dto.CompanyResponseDto;
import com.wooin.wantedinternship.company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Operation(summary = "회사정보 목록 조회")
    @GetMapping("/companies")
    public ResponseEntity<List<CompanyResponseDto>> createCompany() {

        List<CompanyResponseDto> responseDtos = companyService.getCompanyList();
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @Operation(summary = "회사정보 단건 조회")
    @GetMapping("/companies/{companyId}")
    public ResponseEntity<CompanyResponseDto> getCompanyOne(@PathVariable Long companyId) {

        CompanyResponseDto responseDto = companyService.getCompanyOne(companyId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Operation(summary = "회사정보 수정", description = "회사정보 수정 기능. 모든 회사정보 정보를 포함하여 요청해야 한다.")
    @PutMapping("/companies/{companyId}")
    public ResponseEntity<CompanyResponseDto> modifyRecruit(
            @RequestBody CompanyRequestDto requestDto,
            @PathVariable("companyId") Long companyId
    ) {
        CompanyResponseDto responseDto = companyService.modifyCompany(companyId, requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "회사정보 삭제")
    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity<ApiResponseDto> deleteCompany(
            @PathVariable Long companyId
    ) {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(new ApiResponseDto(HttpStatus.OK.value(), companyId +"번의 채용공고가 삭제되었습니다."),HttpStatus.OK);
    }



}

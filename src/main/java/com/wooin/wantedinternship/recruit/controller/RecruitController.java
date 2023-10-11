package com.wooin.wantedinternship.recruit.controller;


import com.wooin.wantedinternship.common.dto.ApiResponseDto;
import com.wooin.wantedinternship.recruit.dto.RecruitDetailResponseDto;
import com.wooin.wantedinternship.recruit.dto.RecruitRequestDto;
import com.wooin.wantedinternship.recruit.dto.RecruitOnBoardResponseDto;
import com.wooin.wantedinternship.recruit.service.RecruitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "채용공고 API", description = "채용공고 생성, 조회, 수정, 삭제 기능과 검색기능.")
public class RecruitController {
    //멤버 선언
    private final RecruitService recruitService;

    //생성자
    public RecruitController(RecruitService recruitService) {
        this.recruitService = recruitService;
    }

    //메소드
    @Operation(summary = "채용공고 목록 조회")
    @GetMapping("/recruitments")
    public ResponseEntity<List<RecruitOnBoardResponseDto>> getRecruitList() {

        List<RecruitOnBoardResponseDto> recruitOnBoardResponseDtos = recruitService.getRecruitList();
        return new ResponseEntity<>(recruitOnBoardResponseDtos, HttpStatus.OK);
    }

    @Operation(summary = "채용공고 단건 조회")
    @GetMapping("/recruitments/{recruitId}")
    public ResponseEntity<RecruitDetailResponseDto> getRecruitOne(
            @PathVariable("recruitId") Long recruitId
    ) {
        RecruitDetailResponseDto responseDto = recruitService.getRecruitOne(recruitId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Operation(summary = "채용공고 생성")
    @PostMapping("/recruitments")
    public ResponseEntity<RecruitOnBoardResponseDto> createRecruit(
            @RequestBody RecruitRequestDto requestDto
            //@RequestBody Long companyId //todo 이후에 회사정보를 유저정보에서 가져오는 식으로 변경 필요
    ) {
        RecruitOnBoardResponseDto responseDto = recruitService.createRecruit(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @Operation(summary = "채용공고 수정", description = "채용공고 수정 기능. 모든 채용공고 정보를 포함하여 요청해야 한다.")
    @PutMapping("/recruitments/{recruitId}")
    public ResponseEntity<RecruitOnBoardResponseDto> modifyRecruit(
            @RequestBody RecruitRequestDto requestDto,
            @PathVariable("recruitId") Long recruitId
    ) {
        RecruitOnBoardResponseDto responseDto = recruitService.modifyRecruit(requestDto, recruitId);
        return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
    }

    @Operation(summary = "채용공고 삭제")
    @DeleteMapping("/recruitments/{recruitId}")
    public ResponseEntity<ApiResponseDto> deleteRecruit(
            @PathVariable Long recruitId
    ) {
        recruitService.deleteRecruit(recruitId);
        return new ResponseEntity<>(new ApiResponseDto(HttpStatus.OK.value(), recruitId+"번의 채용공고가 삭제되었습니다."),HttpStatus.OK);
    }
}

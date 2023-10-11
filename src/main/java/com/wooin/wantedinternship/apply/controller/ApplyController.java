package com.wooin.wantedinternship.apply.controller;

import com.wooin.wantedinternship.apply.dto.ApplyResponseDto;
import com.wooin.wantedinternship.apply.service.ApplyService;
import com.wooin.wantedinternship.common.dto.ApiResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "채용지원 API", description = "채용공고 지원, 조회, 취소.")
public class ApplyController {

    private final ApplyService applyService;

    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @Operation(summary = "채용공고에 지원하기")
    @GetMapping("/apply")
    public ResponseEntity<ApplyResponseDto> createApply(
            @RequestParam Long recruitId,
            @RequestParam Long userId
    ) {
        ApplyResponseDto responseDto = applyService.createApply(recruitId, userId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }




}

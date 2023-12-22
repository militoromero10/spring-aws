package com.milo.springaws.controller;

import com.milo.springaws.dto.RequestRobDto;
import com.milo.springaws.dto.ResponseRobDto;
import com.milo.springaws.service.SolutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
public class SolutionController {
    public static final String BASE_URL_ROB = "/rob";

    private final SolutionService solutionService;

    @PostMapping(BASE_URL_ROB)
    @ResponseStatus(HttpStatus.OK)
    public ResponseRobDto getSolution(@RequestBody RequestRobDto requestDto) {
        var sol = solutionService.rob(requestDto.getMoney());
        return ResponseRobDto.builder().moneyStolen(sol).build();
    }

}

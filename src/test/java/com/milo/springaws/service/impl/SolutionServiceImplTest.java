package com.milo.springaws.service.impl;

import com.milo.springaws.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {SolutionServiceImpl.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SolutionServiceImplTest {

    @Autowired
    SolutionService solutionService;

    @Test
    void test() {
        Integer[] values = {2, 7, 9, 3, 1};
        var expected = -1;
        var actual = assertDoesNotThrow(() -> solutionService.rob(values));

        assertAll(() -> assertEquals(expected, actual));
    }

}
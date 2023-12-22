package com.milo.springaws.controller;

import com.milo.springaws.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(SolutionController.class)
class SolutionControllerTest {
    @Autowired
    MockMvc controller;

    @MockBean
    SolutionService solutionService;

    @Test
    void test() {
        assertAll(
                () -> assertNotNull(solutionService),
                () -> assertNotNull(controller)
        );
    }
}
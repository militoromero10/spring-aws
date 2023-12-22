package com.milo.springaws.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milo.springaws.dto.RequestRobDto;
import com.milo.springaws.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureRestDocs
@WebMvcTest(SolutionController.class)
@ExtendWith(RestDocumentationExtension.class)
class SolutionControllerTest {
    @Autowired
    MockMvc controller;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    SolutionService solutionService;

    @Test
    void test() {
        assertAll(
                () -> assertNotNull(solutionService),
                () -> assertNotNull(controller),
                () -> assertNotNull(objectMapper)
        );
    }

    @Test
    void robTest() throws Exception{
        Integer solve = 12;
        var values = new Integer[]{2, 7, 9, 3, 1};
        var body = RequestRobDto.builder().money(values).build();
        var requestBody = objectMapper.writeValueAsString(body);

        given(solutionService.rob(any(Integer[].class))).willReturn(solve);

        controller.perform(post(SolutionController.BASE_URL_ROB)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andDo(document("rob",
                        responseFields(
                                fieldWithPath("moneyStolen").description("Quantity stolen"))));
    }
}
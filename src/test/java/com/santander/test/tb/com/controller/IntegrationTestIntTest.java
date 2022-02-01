package com.santander.test.tb.com.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@ExtendWith(SpringExtension.class)
@WebMvcTest(IntegrationTestController.class)
class IntegrationTestIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Integration test for integration")
    void integration() throws Exception {
        RequestBuilder request = get("/integrationTest");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Integration, test", result.getResponse().getContentAsString());
    }

}

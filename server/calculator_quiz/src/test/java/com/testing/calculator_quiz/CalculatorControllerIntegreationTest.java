package com.testing.calculator_quiz;

import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorControllerIntegreationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testCalculation() throws JsonProcessingException, Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode calculatorJson = objectMapper.createObjectNode();
        calculatorJson.put("expression", "(56+8)*2");

        mvc.perform(post("/calculator/calculate")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(calculatorJson)))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().json("{\"result\": \"128.0\"}"))
            .andReturn();
    }
}

package com.testing.calculator_quiz;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerIntegrationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldReturnUserInfoForValidUserId() throws JsonProcessingException, Exception {

        mvc.perform(get("/user/6"))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void shouldAddUserByEmail() throws JsonProcessingException, Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode requestBody = objectMapper.createObjectNode();
        requestBody.put("email", "example@email.com");
        requestBody.put("name", "name");


        mvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody.toString()))
                .andExpect(status().isOk())
                .andReturn();
    }
}

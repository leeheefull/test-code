package com.leeheefull.fortunecookie.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leeheefull.fortunecookie.dto.CreateCookieRequest;
import com.leeheefull.fortunecookie.integration.setup.CookieSetUp;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static com.leeheefull.fortunecookie.integration.setup.CookieSetUp.COOKIE_CONTENT;
import static com.leeheefull.fortunecookie.integration.setup.CookieSetUp.COOKIE_TITLE;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CookieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CookieSetUp cookieSetUp;

    @Test
    public void 포춘쿠키_생성() throws Exception {
        //given
        var request = new CreateCookieRequest(COOKIE_TITLE, COOKIE_CONTENT);

        //when
        ResultActions resultActions = mockMvc.perform(post("/cookies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", is(notNullValue())))
                .andExpect(jsonPath("title", Matchers.is(COOKIE_TITLE)))
                .andExpect(jsonPath("content", Matchers.is(COOKIE_CONTENT)));
    }

    @Test
    public void 포춘쿠키_뽑기() throws Exception {
        //given
        cookieSetUp.saveTenCookies();

        //when
        ResultActions resultActions = mockMvc.perform(get("/cookies")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isFound());
    }

}

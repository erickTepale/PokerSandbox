package com.pokersandbox.PokerSandbox.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokersandbox.PokerSandbox.models.dto.MemberRegister;
import com.pokersandbox.PokerSandbox.services.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberControllerTest {

    private MockMvc mockMvc;

    @Mock
    private MemberService memberService;

    @InjectMocks
    private MemberController memberController;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void register_newMember_Test() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/member/register")
                        .content(asJsonString(new MemberRegister(
                                "arguello.chung@gmail.com",
                                "chungarguello",
                                "Chung11161989.",
                                "Chung11161989."
                        )))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.tinTaskList.domain.endpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFindById() throws Exception {
        mockMvc.perform(get("/vehicle/1")).andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}

package com.tinTaskList.endpoint.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.equalTo;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFindById() throws Exception {
        this.mockMvc.perform(get("/vehicle/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("veiculo", equalTo("UNO")))
                .andDo(print());
    }

    @Test
    public void shouldPostVehicle() throws Exception {
        String json = "{\"veiculo\": \"Ka\", \"marca\": \"FORD\", \"ano\": 2015, \"descricao\": \"Completo\", \"vendido\": false}";
        this.mockMvc.perform(post("/vehicle").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("veiculo", equalTo("Ka")));

    }

    @Test
    public void shouldExceptionInvalidMarca() throws Exception {
        String json = "{\"veiculo\": \"FUSION\", \"marca\": \"FORDE\", \"ano\": 2015, \"descricao\": \"Completo\", \"vendido\": false}";
        this.mockMvc.perform(put("/vehicle").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldDeleteVehicle() throws Exception {
        this.mockMvc.perform(delete("/vehicle/3"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldExceptionDeleteInvalidVehicle() throws Exception {
        this.mockMvc.perform(delete("/vehicle/111"))
                .andExpect(status().isNotFound());
    }

}

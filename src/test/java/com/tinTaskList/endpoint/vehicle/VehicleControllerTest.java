package com.tinTaskList.endpoint.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

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
    public void shouldExceptionInvalidMarca() throws Exception {
        String json = "{\"veiculo\": \"FUSION\", \"marca\": \"FORDE\", \"ano\": 2015, \"descricao\": \"Completo\", \"vendido\": false}";
        this.mockMvc.perform(put("/vehicle").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldPostDeleteVehicle() throws Exception {
        String json = "{\"veiculo\": \"Ka\", \"marca\": \"FORD\", \"ano\": 2015, \"descricao\": \"Completo\", \"vendido\": false}";
        this.mockMvc.perform(post("/vehicle").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id", equalTo(8)));

        this.mockMvc.perform(delete("/vehicle/8"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldExceptionDeleteInvalidVehicle() throws Exception {
        this.mockMvc.perform(delete("/vehicle/111"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldUpdateVehicle() throws Exception {
        final String json = "{\"id\": 2, \"veiculo\": \"CRUZE\"}";
        this.mockMvc.perform(put("/vehicle/2").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("veiculo", equalTo("CRUZE")));
    }

    @Test
    public void shouldShouldSellVehicle() throws Exception {
        this.mockMvc.perform(patch("/vehicle/2/sell").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("vendido", equalTo(true)));
    }

    @Test
    public void shouldNotSellVehicle() throws Exception {
        this.mockMvc.perform(patch("/vehicle/4/not-sell").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("vendido", equalTo(false)));
    }

    @Test
    public void shouldListSoldVehicles() throws Exception {
        this.mockMvc.perform(get("/vehicle/sold").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements", equalTo(3)))
                .andExpect(jsonPath(".[0].vendido", hasItem(true)));
    }

    @Test
    public void shouldListNotSoldVehicles() throws Exception {
        this.mockMvc.perform(get("/vehicle/not-sold").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements", equalTo(4)))
                .andExpect(jsonPath(".[0].vendido", hasItem(false)))
                .andDo(print());
    }

    @Test
    public void shouldCountSoldVehicles() throws Exception {
        this.mockMvc.perform(get("/vehicle/sold/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("value", equalTo(3)));
    }

    @Test
    public void shouldCountNotSoldVehicles() throws Exception {
        this.mockMvc.perform(get("/vehicle/not-sold/count"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("value", equalTo(4)));
    }

    @Test
    public void shouldCountDecade() throws Exception {
        this.mockMvc.perform(get("/vehicle/decade/count/2015"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("value", equalTo(4)));
    }

    @Test
    public void shouldCountByMarca() throws Exception {
        this.mockMvc.perform(get("/vehicle/marca/count/VW"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("value", equalTo(3)));
    }

    @Test
    public void shouldListByLastWeek() throws Exception {
        this.mockMvc.perform(get("/vehicle/last-week").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}

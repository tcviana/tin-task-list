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
@Sql({"Clear.sql", "VehicleTest.sql"})
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String getNewVehicle() {
        final String newVehicle = "{\"veiculo\": \"Ka\", \"marca\": \"Ford\", \"ano\": 2015, \"descricao\": \"Completo\", \"vendido\": false}";
        return newVehicle;
    }

    @Test
    public void shouldFindById() throws Exception {
        this.mockMvc.perform(get("/vehicle/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("veiculo", equalTo("UNO")))
                .andDo(print());
    }

    @Test
    public void shouldPostVehicle() throws Exception {

        this.mockMvc.perform(post("/vehicle").content(getNewVehicle()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("veiculo", equalTo("Ka")));

    }

}

package com.tinTaskList.domain.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class VehicleTest {

    @Autowired
    VehicleApplicationServices services;

    @Test
    public void shouldFindById() {
        final Optional<Vehicle> optionalVehicle = services.findById(1L);

        assertThat(optionalVehicle.isPresent(), equalTo(true));

        final Vehicle vehicle = optionalVehicle.get();
        assertThat(vehicle.getAno(), equalTo(1990));
        assertThat(vehicle.getId(), equalTo(1L));
        assertThat(vehicle.getVeiculo(), equalTo("UNO"));
        assertThat(vehicle.getMarca(), equalTo(Marca.FIAT));
        assertThat(vehicle.getDescricao(), equalTo("COMPLETO"));
        assertThat(vehicle.isVendido(), equalTo(false));
        assertThat(vehicle.getCreated(), any(Date.class));
        assertThat(vehicle.getUpdated(), any(Date.class));
    }
}

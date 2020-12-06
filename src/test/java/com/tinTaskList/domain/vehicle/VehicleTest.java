package com.tinTaskList.domain.vehicle;

import com.tinTaskList.domain.logicalTest.vehicle.Vehicle;
import com.tinTaskList.domain.logicalTest.vehicle.VehicleApplicationServices;
import com.tinTaskList.domain.logicalTest.vehicle.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Optional;

@SpringBootTest
public class VehicleTest {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    VehicleApplicationServices services;

    @Test
    @Sql({"Clear.sql", "VehicleTest.sql"})
    public void shouldFindById() {
        final Optional<Vehicle> optionalVehicle = services.findById(1L);

        assertThat(optionalVehicle.isPresent(), equalTo(true));

        final Vehicle vehicle = optionalVehicle.get();
        assertThat(vehicle.getAno(), equalTo(1990));
        assertThat(vehicle.getId(), equalTo(1L));
        assertThat(vehicle.getVeiculo(), equalTo("UNO"));
        assertThat(vehicle.getMarca(), equalTo("FIAT"));
        assertThat(vehicle.getDescricao(), equalTo("COMPLETO"));
        assertThat(vehicle.isVendido(), equalTo(false));
        assertThat(vehicle.getCreated().toString(), equalTo("2010-10-10 00:00:00.0"));
        assertThat(vehicle.getUpdated().toString(), equalTo("2010-10-10 00:00:00.0"));
    }
}
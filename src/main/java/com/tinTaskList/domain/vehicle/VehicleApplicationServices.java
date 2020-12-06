package com.tinTaskList.domain.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class VehicleApplicationServices {

    private final VehicleRepository repository;

    public Optional<Vehicle> findById(final Long id) {
        return repository.findById(id);
    }

    public void post(final Vehicle vehicle) {
        repository.save(vehicle);
    }
}

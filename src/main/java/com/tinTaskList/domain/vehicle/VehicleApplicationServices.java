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

    public Vehicle post(final Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void deleteVehicle(final Long id) {
        repository.deleteById(id);
    }

    public Vehicle update(Vehicle vehicle) {
        return repository.save(vehicle);
    }

}

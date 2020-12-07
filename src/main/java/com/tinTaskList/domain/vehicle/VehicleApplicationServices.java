/**
* Esta classe representa os serviços do {@link com.tinTaskList.domain.vehicle.Vehicle}.
*
* @author  Tiago Coutinho Viana
* @version  1.0
*/

package com.tinTaskList.domain.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
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

    public Page<Vehicle> findByVendido(Pageable page) {
        return repository.findByVendido(true, page);
    }

    public Page<Vehicle> findByNotVendido(Pageable page) {
        return repository.findByVendido(false, page);
    }

    public Integer countSold() {
        return repository.countByVendido(true);
    }

    public Integer countNotSold() {
        return repository.countByVendido(false);
    }

    public Integer countDecadeByYear(Integer year) {
        final Integer initialYear = (year / 10) * 10;
        final Integer finalYear = initialYear + 9;
        return repository.countByAnoBetween(initialYear, finalYear);
    }

    public Integer countByMarca(Marca marca) {
        return repository.countByMarca(marca);
    }

    public Page<Vehicle> findByRecordLastWeek(Pageable page) {
        final Date weekPassed = Date.valueOf(LocalDate.now().plusDays(-7));
        return repository.findByCreatedGreaterThan(weekPassed,page);
    }
}

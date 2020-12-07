package com.tinTaskList.domain.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.sql.Date;
import java.time.LocalDate;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor {

    Page<Vehicle> findByVendido(Boolean vendido, Pageable page);

    Integer countByVendido(Boolean vendido);

    Integer countByAnoBetween(Integer initialYear, Integer finalYear);

    Integer countByMarca(Marca marca);

    Page<Vehicle> findByCreatedGreaterThan(Date weekPassed, Pageable page);
}

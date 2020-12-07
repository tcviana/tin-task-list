package com.tinTaskList.domain.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

    Page<Vehicle> findByVendido(Boolean vendido, Pageable page);

    Integer countByVendido(Boolean vendido);
}

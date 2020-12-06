package com.tinTaskList.endpoints;

import com.tinTaskList.domain.vehicle.Vehicle;
import com.tinTaskList.domain.vehicle.VehicleApplicationServices;
import com.tinTaskList.infra.dto.VehicleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleApplicationServices services;

    @GetMapping("/{id}")
    public VehicleDto getById(@PathVariable("id") final Long id) {;
        return new VehicleDto(services.findById(id));
    }
}

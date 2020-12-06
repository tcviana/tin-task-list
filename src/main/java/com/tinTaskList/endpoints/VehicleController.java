package com.tinTaskList.endpoints;

import com.tinTaskList.domain.vehicle.Vehicle;
import com.tinTaskList.domain.vehicle.VehicleApplicationServices;
import com.tinTaskList.infra.dto.VehicleDto;
import com.tinTaskList.infra.dto.VehicleForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<VehicleDto> newVehicle(@RequestBody final VehicleForm vehicleForm, UriComponentsBuilder uriBuil) {
        final Vehicle vehicle = vehicleForm.convertToVehicle();
        services.post(vehicle);

        URI uri = uriBuil.path("/vehicle/{id}").buildAndExpand(vehicle.getId()).toUri();
        return ResponseEntity.created(uri).body(new VehicleDto(vehicle));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeVehicle(@PathVariable("id") final Long id) {
        if (services.findById(id).isPresent()) {
            services.deleteVehicle(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable final Long id, @RequestBody VehicleForm form) {
        Vehicle vehicle = services.update(form.convertToVehicle());
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }

    @PatchMapping("/{id}/sell")
    public ResponseEntity<VehicleDto> sellVehicle(@PathVariable final Long id) {
        Vehicle vehicle = services.findById(id).get();
        vehicle.sell();
        services.update(vehicle);
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }

    @PatchMapping("/{id}/purchase")
    public ResponseEntity<VehicleDto> purchaseVehicle(@PathVariable final Long id) {
        Vehicle vehicle = services.findById(id).get();
        vehicle.purchase();
        services.update(vehicle);
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }
}

package com.tinTaskList.endpoints;

import com.tinTaskList.domain.vehicle.Marca;
import com.tinTaskList.domain.vehicle.Vehicle;
import com.tinTaskList.domain.vehicle.VehicleApplicationServices;
import com.tinTaskList.domain.vehicle.VehicleFilter;
import com.tinTaskList.infra.dto.VehicleDto;
import com.tinTaskList.infra.dto.VehicleForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vehicles")
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
        return services.deleteVehicle(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable final Long id, @RequestBody VehicleForm form) {
        Vehicle vehicle = services.update(form.convertToVehicle());
        return ResponseEntity.ok(new VehicleDto(vehicle));
    }

    @PatchMapping("/{id}/sell")
    public ResponseEntity<VehicleDto> sellVehicle(@PathVariable final Long id) {
        return ResponseEntity.ok(new VehicleDto(services.sellVehicle(id)));
    }

    @PatchMapping("/{id}/not-sell")
    public ResponseEntity<VehicleDto> notSellVehicle(@PathVariable final Long id) {
        return ResponseEntity.ok(new VehicleDto(services.notSellVehicle(id)));
    }

    @GetMapping("/not-sold")
    public Page<VehicleDto> listNotSoldVehicle(@PageableDefault(sort = "ano", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable page) {
        Page<Vehicle> vehicles = services.findByNotVendido(page);
        return VehicleDto.convertList(vehicles);
    }

    @GetMapping("/sold")
    public Page<VehicleDto> listSoldVehicle(@PageableDefault(sort = "ano", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable page) {
        Page<Vehicle> vehicles = services.findByVendido(page);
        return VehicleDto.convertList(vehicles);
    }

    @GetMapping("/sold/total")
    public String totalSold() {
        final String json = createJson(services.countSold());
        return json;
    }

    @GetMapping("/not-sold/total")
    public String totalNotSold() {
        final String json = createJson(services.countNotSold());
        return json;
    }

    @GetMapping("/decade/{year}/total")
    public String totalByDecade(@PathVariable final Integer year) {
        final String json = createJson(services.countDecadeByYear(year));
        return json;
    }

    @GetMapping("/marca/{marca}/total")
    public String totalByMarca(@PathVariable final Marca marca) {
        final String json = createJson(services.countByMarca(marca));
        return json;
    }

    @GetMapping("/last-week")
    public Page<VehicleDto> retrieveRecordLastWeek(@PageableDefault(sort = "ano", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable page) {
        Page<Vehicle> vehicles = services.findByRecordLastWeek(page);
        return VehicleDto.convertList(vehicles);
    }

    private String createJson(Integer i) {
        return "{\"value\": " + i + "}";
    }

    @GetMapping("/find")
    public Page<VehicleDto> retrieveWithFilter(final VehicleFilter filter, final Pageable page) {
        Page<Vehicle> vehicles = services.find(filter, page);
        return VehicleDto.convertList(vehicles);
    }
}

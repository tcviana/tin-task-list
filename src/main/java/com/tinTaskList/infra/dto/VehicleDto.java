package com.tinTaskList.infra.dto;

import com.tinTaskList.domain.vehicle.Vehicle;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class VehicleDto {

    private long id;
    private String veiculo;
    private String marca;
    private int ano;
    private String descricao;
    private boolean vendido;
    private Date created;
    private Date updated;

    public VehicleDto(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.veiculo = vehicle.getVeiculo();
        this.marca = vehicle.getMarca();
        this.ano = vehicle.getAno();
        this.descricao = vehicle.getDescricao();
        this.vendido = vehicle.isVendido();
        this.created = vehicle.getCreated();
        this.updated = vehicle.getUpdated();
    }

    public VehicleDto(Optional<Vehicle> vehicle) {
        this.id = vehicle.get().getId();
        this.veiculo = vehicle.get().getVeiculo();
        this.marca = vehicle.get().getMarca();
        this.ano = vehicle.get().getAno();
        this.descricao = vehicle.get().getDescricao();
        this.vendido = vehicle.get().isVendido();
        this.created = vehicle.get().getCreated();
        this.updated = vehicle.get().getUpdated();
    }

    public static List<VehicleDto> convertList(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
    }
}

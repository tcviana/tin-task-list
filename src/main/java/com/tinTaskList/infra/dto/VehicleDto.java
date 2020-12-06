package com.tinTaskList.infra.dto;

import com.tinTaskList.domain.vehicle.Vehicle;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VehicleDto {

    private long id;
    private String veiculo;
    private String marca;
    private int ano;
    private String descricao;
    private boolean vendido;
    private Date created;
    private Date updated;

    public VehicleDto(Optional<Vehicle> vehicle) {
        this.id = vehicle.getId();
        this.veiculo = vehicle.getVeiculo();
        this.marca = vehicle.getMarca();
        this.ano = vehicle.getAno();
        this.descricao = vehicle.getDescricao();
        this.vendido = vehicle.isVendido();
        this.created = vehicle.getCreated();
        this.updated = vehicle.getUpdated();
    }

    public static List<VehicleDto> convertList(List<Vehicle> vehicles) {
        return vehicles.stream().map(VehicleDto::new).collect(Collectors.toList());
    }
}

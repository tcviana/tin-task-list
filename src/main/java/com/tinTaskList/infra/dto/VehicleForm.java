/**
 * Esta classe representa a entrada do {@link com.tinTaskList.domain.vehicle.Vehicle} como objeto json.
 *
 * @author  Tiago Coutinho Viana
 * @version  1.0
 */

package com.tinTaskList.infra.dto;

import com.tinTaskList.domain.vehicle.Marca;
import com.tinTaskList.domain.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class VehicleForm {

    private String veiculo;
    private Marca marca;
    private Integer ano;
    private String descricao;
    private Boolean vendido;

    public VehicleForm(VehicleForm vehicle) {
        this.veiculo = vehicle.getVeiculo();
        this.marca = vehicle.getMarca();
        this.ano = vehicle.getAno();
        this.descricao = vehicle.getDescricao();
        this.vendido = vehicle.getVendido();
    }

    public Vehicle convertToVehicle() {
        final Vehicle vehicle = new Vehicle(this.veiculo, this.marca, this.ano, this.descricao, this.vendido);
        return vehicle;
    }
}

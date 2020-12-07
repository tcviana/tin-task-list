/**
 * Esta classe representa a trasnferência do {@link com.tinTaskList.domain.vehicle.Vehicle}
 * para ser utilizada como objeto json.
 *
 * @author  Tiago Coutinho Viana
 * @version  1.0
 */

package com.tinTaskList.infra.dto;

import com.tinTaskList.domain.vehicle.Marca;
import com.tinTaskList.domain.vehicle.Vehicle;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.Optional;

@Getter
public class VehicleDto {

    private Long id;
    private String veiculo;
    private Marca marca;
    private Integer ano;
    private String descricao;
    private Boolean vendido;
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

    public static Page<VehicleDto> convertList(Page<Vehicle> vehicles) {
        return vehicles.map(VehicleDto::new);
    }
}

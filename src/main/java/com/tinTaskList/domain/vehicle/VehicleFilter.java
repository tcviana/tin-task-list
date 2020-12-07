/**
 * Esta classe contém as propriedades para filtrar os dados do {@link com.tinTaskList.domain.vehicle.Vehicle}
 *
 * @author  Tiago Coutinho Viana
 * @version  1.0
 */

package com.tinTaskList.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VehicleFilter {
    private String veiculo;
    private Marca marca;
    private Integer ano;
    private String descricao;
}

/**
 * Esta classe realiza os filtros de pesquisa do veículo.
 *
 * @author  Tiago Coutinho Viana
 * @version  1.0
 */

package com.tinTaskList.domain.vehicle;

import com.tinTaskList.infra.specification.BaseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class VehicleSpecification extends BaseSpecification {

    public Specification<Vehicle> specification(final VehicleFilter filter) {
        return (root, query, cb) -> {
          query.distinct(true);
          return where(
                  where(this.attributeEqual("marca", filter.getMarca()))
                    .and(this.attributeEqual("ano", filter.getAno()))
                    .and(this.attributeContains("veiculo", filter.getVeiculo()))
                    .and(this.attributeContains("descricao", filter.getDescricao()))
          ).toPredicate(root, query, cb);
        };
    }
}

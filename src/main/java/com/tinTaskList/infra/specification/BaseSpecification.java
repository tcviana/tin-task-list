/**
 * Esta classe configura os filtros básicos para utilizar no banco de dados
 *
 * @author  Tiago Coutinho Viana
 * @version  1.0
 */

package com.tinTaskList.infra.specification;

import org.springframework.data.jpa.domain.Specification;

public abstract class BaseSpecification<T> {
    protected static final String WILDCARD = "%";

    protected String containsLowerCase(final String searchField) {
        return BaseSpecification.WILDCARD + searchField.trim().toLowerCase() + BaseSpecification.WILDCARD;
    }

    protected Specification<T> attributeContains(final String attribute, final String value) {
        if (value == null) {
            return null;
        }
        return (root, query, cb) -> cb.like(cb.lower(root.get(attribute)), this.containsLowerCase(value));
    }

    protected Specification<T> attributeEqual(final String attribute, final Object value) {
        if (value == null) {
            return null;
        }
        return (root, query, cb) -> cb.equal(cb.upper(root.get(attribute)), value);
    }
}

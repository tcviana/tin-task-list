/**
* Esta classe realiza o cálculo fatorial de um número inteiro.
* <p>Para utilizá-la informe o número desejado em seu construtor
* e chame o método <b>calculate</b>. </p>
*
* @author  Tiago Coutinho Viana
* @version  1.0
*/

package com.tinTaskList.domain.logicalTest.factorial;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Factorial {
    private long value;

    public long calculate() {
        long calculated = value;

        for (long i=value; i>1; i--) {
            calculated *= (i-1);
        }

        return calculated;
    }
}

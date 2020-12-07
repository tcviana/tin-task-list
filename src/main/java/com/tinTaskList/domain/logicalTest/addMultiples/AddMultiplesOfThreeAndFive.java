/**
* Esta classe realiza a soma dos de todos os números que sejam múltiplos de
* 3 ou 5, ou seja, ao informar o número 10 esta classe
* irá somar seus números naturais abaixo de 10, ou seja, 9,6,5 e 3.
* <p> Utilização: informe um valor inteiro em seu construtor e chame o 
* método público <b>calculate</b>. </p>
*
* @author  Tiago Coutinho Viana
* @version  1.0
*/

package com.tinTaskList.domain.logicalTest.addMultiples;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AddMultiplesOfThreeAndFive {
    private int value;

    public long calculate() {
        long calculated = 0;

        for (int i=(value-1); i>2; i--) {
            if (divisibleByFive(i) || divisibleByThree(i)) {
                calculated += i;
            }
        }

        return calculated;
    }

    private boolean divisibleByThree(int value) {
        final double calc = value % 3;
        return calc == 0.0;
    }

    private boolean divisibleByFive(int value) {
        final double calc = value % 5;
        return calc == 0.0;
    }
}

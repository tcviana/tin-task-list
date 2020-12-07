/**
* Esta classe realiza a ordenação de um vetor utilizando o conceito Bublle Sort.
* <p> Utilização: informe um vetor em seu construtor e chame o 
* método público <b>order</b>. </p>
*
* @author  Tiago Coutinho Viana
* @version  1.0
*/

package com.tinTaskList.domain.logicalTest.bubbleSort;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BubbleSort {
    private int[] vector;

    public void order() {
        final int vectorLength = vector.length;

        for (int x=0; x<vectorLength; x++ ) {
            for (int y=1; y < (vectorLength - x); y++) {
                swapValues(y-1, y);
            }
        }
    }

    private void swapValues(int leftValue, int rightValue) {
        if (vector[leftValue] > vector[rightValue]) {
            int swap = vector[leftValue];
            vector[leftValue] = vector[rightValue];
            vector[rightValue] = swap;
        }
    }
}

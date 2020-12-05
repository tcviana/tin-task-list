package com.tinTaskList.tinTaskList.domain.logicalTest.bubbleSort;

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

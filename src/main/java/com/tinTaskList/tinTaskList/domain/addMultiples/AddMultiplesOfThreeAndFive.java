package com.tinTaskList.tinTaskList.domain.addMultiples;

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

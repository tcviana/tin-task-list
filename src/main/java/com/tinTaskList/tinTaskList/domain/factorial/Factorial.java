package com.tinTaskList.tinTaskList.domain.factorial;

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

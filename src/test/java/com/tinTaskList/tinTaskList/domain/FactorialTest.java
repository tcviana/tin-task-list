package com.tinTaskList.tinTaskList.domain;

import com.tinTaskList.tinTaskList.domain.factorial.Factorial;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class FactorialTest {

    @Test
    public void shouldCalculate() {
        final Factorial factorial = new Factorial(5);
        assertThat(factorial.calculate(), equalTo(120L));

        factorial.setValue(4);
        assertThat(factorial.calculate(), equalTo(24L));

        factorial.setValue(1);
        assertThat(factorial.calculate(), equalTo(1L));

        factorial.setValue(0);
        assertThat(factorial.calculate(), equalTo(0L));
    }
}

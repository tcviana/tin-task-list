package com.tinTaskList.domain.logicalTest;

import com.tinTaskList.domain.logicalTest.addMultiples.AddMultiplesOfThreeAndFive;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class AddMultiplesOfThreeAndFiveTest {

    @Test
    public void shouldCalculate() {
        AddMultiplesOfThreeAndFive addMultiplesOfThreeAndFive = new AddMultiplesOfThreeAndFive(10);
        assertThat(addMultiplesOfThreeAndFive.calculate(), equalTo(23L));
    }
}

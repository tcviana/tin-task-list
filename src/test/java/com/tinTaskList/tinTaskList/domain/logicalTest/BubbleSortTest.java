package com.tinTaskList.tinTaskList.domain.logicalTest;

import com.tinTaskList.tinTaskList.domain.logicalTest.bubbleSort.BubbleSort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class BubbleSortTest {


    private final int[] vector = {5, 3, 2, 4, 7, 1, 0, 6};
    private BubbleSort bubbleSort = new BubbleSort(vector);

    @Test
    public void shouldOrder() {
        final int[] orderedVector = {0,1,2,3,4,5,6,7};
        bubbleSort.order();
        assertThat(bubbleSort.getVector(), equalTo(orderedVector));
    }
}

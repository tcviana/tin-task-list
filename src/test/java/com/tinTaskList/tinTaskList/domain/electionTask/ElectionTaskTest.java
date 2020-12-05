package com.tinTaskList.tinTaskList.domain.electionTask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ElectionTaskTest {

    private ElectionTask getElectionTask() {
        final ElectionTask electionTask = new ElectionTask(800, 150, 50);
        return electionTask;
    }

    @Test
    public void shouldValidVotes() {
        assertThat(getElectionTask().validVotes(), equalTo(80.0));
    }

    @Test
    public void shouldBlankVotes() {
        assertThat(getElectionTask().blankVotes(), equalTo(15.0));
    }

    @Test
    public void shouldNullVotes() {
        assertThat(getElectionTask().nullVotes(), equalTo(5.0));
    }
}

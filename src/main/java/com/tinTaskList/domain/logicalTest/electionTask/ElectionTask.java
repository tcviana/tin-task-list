package com.tinTaskList.domain.logicalTest.electionTask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ElectionTask {

    private int validVotes;
    private int blankVotes;
    private int nullVotes;

    public int totalVotes() {
        return validVotes + blankVotes + nullVotes;
    }

    private double calculateVote (int votes) {
        return votes * 100 / totalVotes();
    }

    public double validVotes() {
        return calculateVote(this.validVotes);
    }

    public double blankVotes() {
        return calculateVote(this.blankVotes);
    }

    public double nullVotes() {
        return calculateVote(this.nullVotes);
    }

}

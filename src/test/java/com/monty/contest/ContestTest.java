package com.monty.contest;

import org.junit.Test;

public class ContestTest {

    @Test
    public void testThatContestIsCompletedWithoutUnexpectedErrors() {
        Contest contest = new Contest();
        contest.start();
    }
}

package com.monty.contest.result;


import com.monty.contest.participants.Contestor;
import com.monty.contest.participants.ContestorTest;
import com.monty.contest.props.Box;
import com.monty.contest.props.BoxContent;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultAggregateTest {

    @Test
    public void testThatAWinIsCounted() {
        Contestor contestor = new Contestor(ContestorTest.NAME, ContestorTest.CHANGE_MIND);
        Box winnerBox = new Box(1, BoxContent.MONEY);
        Result result = new Result(winnerBox);


        ResultAggregate resultAggregate = new ResultAggregate(contestor);
        assertEquals(0, resultAggregate.numberOfWins);

        resultAggregate.countWins(result);

        assertEquals(1, resultAggregate.numberOfWins);
    }

    @Test
    public void testThatALossIsNotCounted() {
        Contestor contestor = new Contestor(ContestorTest.NAME, ContestorTest.CHANGE_MIND);
        Box emptyBox = new Box(1, BoxContent.EMPTY);
        Result result = new Result(emptyBox);


        ResultAggregate resultAggregate = new ResultAggregate(contestor);
        resultAggregate.countWins(result);

        assertEquals(0, resultAggregate.numberOfWins);
    }
}

package com.monty.contest.result;

import com.monty.contest.participants.Contestor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultAggregate {

    private static final Logger logger = LoggerFactory.getLogger(ResultAggregate.class);

    private Contestor contestor;
    int numberOfWins = 0;

    public ResultAggregate(Contestor contestor) {
        this.contestor = contestor;
    }

    public void countWins(Result result) {
        if(result.isAWin()) {
            numberOfWins++;
        }
    }

    public void announceResult(int chancesOfWinning) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--> ");
        stringBuilder.append(contestor.getName() + " succeeded in " + numberOfWins + " number of wins ");
        stringBuilder.append("out of " + chancesOfWinning + " attempts");

        logger.info(stringBuilder.toString());
    }
}

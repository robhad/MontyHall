package com.monty.contest.participants;

import com.monty.contest.GameShowSupervisor;
import com.monty.contest.props.Box;
import com.monty.contest.result.Result;
import com.monty.contest.result.ResultAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Host {

    private static final Logger logger = LoggerFactory.getLogger(ResultAggregate.class);

    private GameShowSupervisor gameShowSupervisor;

    public Host(GameShowSupervisor gameShowSupervisor) {
        this.gameShowSupervisor = gameShowSupervisor;
    }

    public Result startNewGameRound(Contestor contestor) {
        gameShowSupervisor.deployBoxes();

        // We don't want the contestor to get access to the actual box, only their numbers
        int boxNumber = contestor.chooseABoxNumber();
        Box contestorsOriginalChoice = gameShowSupervisor.provideBox(boxNumber);

        Box emptyBox = gameShowSupervisor.provideAnEmptyBox(contestorsOriginalChoice);

        List<Integer> remainingBoxNumbers = gameShowSupervisor.provideTheRemainingBoxNumbers(
                                        contestorsOriginalChoice, emptyBox);
        int finalDecisionNumber = contestor.makeFinalDecision(remainingBoxNumbers);
        Box finalDecision = gameShowSupervisor.provideBox(finalDecisionNumber);

        return new Result(finalDecision);
    }

    public void announcingResult(ResultAggregate resultAggregateDeterminedContestor,
                                 ResultAggregate resultAggregateSmartContestor,
                                 int numberOfAttempts) {

        logger.info("\n----------------------");
        logger.info("The result is");
        logger.info("----------------------");
        resultAggregateDeterminedContestor.announceResult(numberOfAttempts);
        resultAggregateSmartContestor.announceResult(numberOfAttempts);
        logger.info("----------------------\n");
    }
}

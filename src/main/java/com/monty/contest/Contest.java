package com.monty.contest;

import com.monty.contest.participants.Contestor;
import com.monty.contest.participants.Host;
import com.monty.contest.result.Result;
import com.monty.contest.result.ResultAggregate;
import org.springframework.stereotype.Component;

@Component
public class Contest {

    private static final int NUMBER_OF_ROUNDS = 100000;

    public void start() {
        Contestor determinedContestor = new Contestor("Sticking with first choice contestor", false);
        Contestor smartContestor = new Contestor("Changing box contestor", true);

        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();

        Host host = new Host(gameShowSupervisor);

        ResultAggregate resultAggregateDeterminedContestor = new ResultAggregate(determinedContestor);
        ResultAggregate resultAggregateSmartContestor = new ResultAggregate(smartContestor);

        for(int i = 0; i < NUMBER_OF_ROUNDS; i++) {
            Result resultForDeterminedContestor = host.startNewGameRound(determinedContestor);
            resultAggregateDeterminedContestor.countWins(resultForDeterminedContestor);

            Result resultForSmartContestor = host.startNewGameRound(smartContestor);
            resultAggregateSmartContestor.countWins(resultForSmartContestor);
        }

        host.announcingResult(resultAggregateDeterminedContestor, resultAggregateSmartContestor, NUMBER_OF_ROUNDS);
    }
}

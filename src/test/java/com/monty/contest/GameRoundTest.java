package com.monty.contest;

import com.monty.contest.participants.Contestor;
import com.monty.contest.participants.ContestorTest;
import com.monty.contest.participants.Host;
import com.monty.contest.result.Result;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameRoundTest {

    @Test
    public void testThatAGameRoundEndsUpInAResult() {
        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();
        Contestor contestor = new Contestor(ContestorTest.NAME, ContestorTest.CHANGE_MIND);

        Host host = new Host(gameShowSupervisor);
        Result result = host.startNewGameRound(contestor);

        assertTrue(result.isAWin() || !result.isAWin());
    }
}

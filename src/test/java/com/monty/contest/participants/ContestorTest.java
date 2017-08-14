package com.monty.contest.participants;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.monty.contest.props.BoxNumbers.MAX_NUMBER;
import static com.monty.contest.props.BoxNumbers.MIN_NUMBER;
import static org.junit.Assert.*;

public class ContestorTest {

    public static final String NAME = "Monty";
    public static final boolean CHANGE_MIND = true;
    private static final int CHANGE_MIND_TO_NUMBER = MAX_NUMBER + 1;

    @Test
    public void testThatCorrectNameIsGiven() {
        Contestor contestor = new Contestor(NAME, CHANGE_MIND);

        assertEquals(NAME, contestor.getName());
    }

    @Test
    public void testThatAnAllowedNumberIsChoosen() {
        Contestor contestor = new Contestor(NAME, CHANGE_MIND);

        int choosenNumber = contestor.chooseABoxNumber();

        assertTrue(choosenNumber >= MIN_NUMBER);
        assertTrue(choosenNumber <= MAX_NUMBER);
    }

    @Test
    public void testThatContestorIsAbleToChangeHisMind() {
        Contestor contestor = new Contestor(NAME, CHANGE_MIND);
        int originalChoosenNumber = contestor.chooseABoxNumber();
        List<Integer> remainingNumber = Arrays.asList(CHANGE_MIND_TO_NUMBER);

        int finalDecisionNumber = contestor.makeFinalDecision(remainingNumber);

        assertNotEquals(originalChoosenNumber, finalDecisionNumber);
        assertEquals(CHANGE_MIND_TO_NUMBER, finalDecisionNumber);
    }

    @Test
    public void testThatContestorSticksWithFirstDecision() {
        Contestor contestor = new Contestor(NAME, !CHANGE_MIND);

        int originalChoosenNumber = contestor.chooseABoxNumber();
        List<Integer> remainingNumber = Arrays.asList(CHANGE_MIND_TO_NUMBER);

        int finalDecisionNumber = contestor.makeFinalDecision(remainingNumber);

        assertEquals(originalChoosenNumber, finalDecisionNumber);
    }
}

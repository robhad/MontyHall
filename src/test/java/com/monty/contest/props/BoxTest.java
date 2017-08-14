package com.monty.contest.props;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static com.monty.contest.props.BoxContent.*;

public class BoxTest {

    private static final int BOX_NUMBER = 1;

    @Test
    public void testThatCorrectBoxNumberIsGiven() {
        Box box = new Box(BOX_NUMBER, MONEY);

        assertEquals(BOX_NUMBER, box.getNumber());
    }

    @Test
    public void testThatBoxCanBeAWinner() {
        Box box = new Box(BOX_NUMBER, MONEY);

        assertTrue(box.containsMoney());
    }

    @Test
    public void testThatBoxCanBeEmpty() {
        Box box = new Box(BOX_NUMBER, EMPTY);

        assertTrue(box.isEmpty());
    }
}

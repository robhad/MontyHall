package com.monty.contest.props;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoxNumbersTest {

    @Test
    public void testThatSelectedNumbersAreInRange() {
        for(int i = 0; i < 100; i++) {
            int randomNumberInRange = BoxNumbers.getRandomAllowedNumber();

            assertTrue(randomNumberInRange >= BoxNumbers.MIN_NUMBER);
            assertTrue(randomNumberInRange <= BoxNumbers.MAX_NUMBER);
        }

    }
}

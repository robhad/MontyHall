package com.monty.contest.props;

import java.util.concurrent.ThreadLocalRandom;

public class BoxNumbers {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 3;

    public static final int getRandomAllowedNumber() {
        return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }
}

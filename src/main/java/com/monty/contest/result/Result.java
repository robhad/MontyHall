package com.monty.contest.result;

import com.monty.contest.props.Box;

public class Result {

    private Box choosenBox;

    public Result(Box choosenBox) {
        this.choosenBox = choosenBox;
    }

    public boolean isAWin() {
        return choosenBox.containsMoney();
    }
}



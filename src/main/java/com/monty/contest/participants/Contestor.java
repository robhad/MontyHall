package com.monty.contest.participants;

import com.monty.contest.props.BoxNumbers;

import java.util.List;

public class Contestor {

    private String name;
    private boolean changeMyMind; // could if decision were greater in numbers supply a function instead with the desired behaviour
    private int originalChoice;

    public Contestor(String name, boolean changeMyMind) {
        this.name = name;
        this.changeMyMind = changeMyMind;
    }

    public String getName() {
        return name;
    }

    public int chooseABoxNumber() {
        int choosenNumber = BoxNumbers.getRandomAllowedNumber();
        this.originalChoice = choosenNumber;

        return choosenNumber;
    }

    public int makeFinalDecision(List<Integer> remainingBoxNumbers) {
        int finalAnswer = originalChoice;
        if(changeMyMind) {
            finalAnswer = remainingBoxNumbers.get(0);
        }
        return finalAnswer;
    }
}

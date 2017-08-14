package com.monty.contest.props;

import java.util.Objects;

import static com.monty.contest.props.BoxContent.*;

public class Box {

    private int number;
    private BoxContent content;

    public Box(int boxNumber, BoxContent content) {
        this.number = boxNumber;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public boolean containsMoney() {
        return content == MONEY;
    }

    public boolean isEmpty() {
        return content == EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return number == box.number &&
                content == box.content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, content);
    }
}

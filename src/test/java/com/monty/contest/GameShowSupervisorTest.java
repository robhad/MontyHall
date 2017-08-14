package com.monty.contest;

import com.monty.contest.props.Box;
import com.monty.contest.props.BoxContent;
import com.monty.contest.props.BoxNumbers;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class GameShowSupervisorTest {

    @Test
    public void testBoxesShouldBeNoMoreThanMaximumNumber() {
        Map<Integer, Box> boxes = new GameShowSupervisor().deployBoxes();

        assertTrue(boxes.size() == BoxNumbers.MAX_NUMBER);
    }

    @Test
    public void testThatOneBoxAndOneBoxOnlyShouldContainMoney() {
        Map<Integer, Box> boxes = new GameShowSupervisor().deployBoxes();

        List<Box> moneyBox = boxes.values()
                                .stream()
                                .filter(box -> box.containsMoney())
                                .collect(Collectors.toList());

        assertTrue(moneyBox.size() == 1);
    }

//    @Test
//    public void testGiveUsTheMoneyBox() {
//        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();
//        gameShowSupervisor.deployBoxes();
//
//        Box box = gameShowSupervisor.tellCorrectBox();
//
//        assertTrue(box.containsMoney());
//    }

    @Test
    public void testGiveUsTheReaminingBoxNumbers() {
        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();
        Map<Integer, Box> boxes = gameShowSupervisor.deployBoxes();

        int originalNumberOfBoxes = boxes.size();
        assertEquals(BoxNumbers.MAX_NUMBER, originalNumberOfBoxes);

        Box boxToExclude = gameShowSupervisor.provideBox(BoxNumbers.MAX_NUMBER);
        List<Integer> remainingBoxNumbers = gameShowSupervisor.provideTheRemainingBoxNumbers(boxToExclude);

        assertEquals(BoxNumbers.MAX_NUMBER - 1, remainingBoxNumbers.size());
        assertFalse(remainingBoxNumbers.contains(boxToExclude));
    }

    @Test
    public void testGiveUsAnEmptyBox() {
        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();
        gameShowSupervisor.deployBoxes();

        Box emptyBox = gameShowSupervisor.provideAnEmptyBox();

        assertTrue(emptyBox.isEmpty());
    }

    @Test
    public void testGiveUsTheCorrectBoxByBoxNumber() {
        GameShowSupervisor gameShowSupervisor = new GameShowSupervisor();
        gameShowSupervisor.deployBoxes();

        Box box = gameShowSupervisor.provideBox(BoxNumbers.MAX_NUMBER);

        assertEquals(BoxNumbers.MAX_NUMBER, box.getNumber());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testThatDeployedBoxesCannotBeModified() {
        Map<Integer, Box> boxes = new GameShowSupervisor().deployBoxes();
        boxes.put(4, new Box(4, BoxContent.EMPTY));
    }
}

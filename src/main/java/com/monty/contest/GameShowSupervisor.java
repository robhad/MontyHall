package com.monty.contest;

import com.monty.contest.props.Box;
import com.monty.contest.props.BoxContent;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.monty.contest.props.BoxNumbers.MIN_NUMBER;

public final class GameShowSupervisor {

    private Map<Integer, Box> boxes;

    GameShowSupervisor() {}

    public Map<Integer, Box> deployBoxes() {
        List<Box> listOfBoxes = createBoxes();
        Collections.shuffle(listOfBoxes);

        boxes = listOfBoxes
                    .stream()
                    .collect(Collectors.toMap(Box::getNumber, Function.identity()));

        return Collections.unmodifiableMap(new LinkedHashMap(boxes));
    }

    public Box provideBox(int boxNumber) {
        return boxes.get(boxNumber);
    }

    public List<Integer> provideTheRemainingBoxNumbers(Box... alreadyTargetedBoxes) {
        List<Box> boxesToExclude = Arrays.asList(alreadyTargetedBoxes);

        return boxes.values()
                .stream()
                .filter(box -> !boxesToExclude.contains(box))
                .map(box -> box.getNumber())
                .collect(Collectors.toList());
    }

    public Box provideAnEmptyBox(Box... exclusive) {
        List<Box> exclusiveList = Arrays.asList(exclusive);
        Box correctBox = tellCorrectBox();

        return boxes.values()
                .stream()
                .filter(box -> !box.equals(correctBox) && !exclusiveList.contains(box))
                .findFirst().get(); // Error handling coming up in version 2.0
    }

    private Box tellCorrectBox() {
        return boxes.values().stream()
                .filter(box -> box.containsMoney())
                .findFirst().get();
    }

    private List<Box> createBoxes() {
        List<Integer> boxNumbers = Arrays.asList(MIN_NUMBER, MIN_NUMBER + 1, MIN_NUMBER + 2);
        Collections.shuffle(boxNumbers);

        Box moneyBox = new Box(boxNumbers.get(0), BoxContent.MONEY);
        Box emptyBox1 = new Box(boxNumbers.get(1), BoxContent.EMPTY);
        Box emptyBox2 = new Box(boxNumbers.get(2), BoxContent.EMPTY);

        return Arrays.asList(moneyBox, emptyBox1, emptyBox2);
    }
}

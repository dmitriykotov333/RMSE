package eye.tracking.graph.input;


import eye.tracking.graph.exception.MenuOutException;

import java.util.List;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }


    public String ask(String question) {
        return input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.ask(question, range);
                invalid = false;
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error");
            }
        } while (invalid);
        return value;
    }
}
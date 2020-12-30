package eye.tracking.graph.input;

import eye.tracking.graph.exception.MenuOutException;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {


    private Scanner scanner = new Scanner(System.in);


    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("ErrorOutMenuRange");
        }
        return key;
    }
}
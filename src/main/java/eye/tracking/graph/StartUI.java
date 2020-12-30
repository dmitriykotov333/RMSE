package eye.tracking.graph;

import eye.tracking.graph.input.ConsoleInput;
import eye.tracking.graph.input.Input;
import eye.tracking.graph.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Action tracker;

    private StartUI(Input input, Action tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    private void init() {
        Menu menu = new Menu(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        UserAction deleteAction = new UserAction() {
            public int key() {
                return 6;
            }

            public void execute(Input input, Action tracker) {

            }

            public String info() {
                return String.valueOf(key());
            }
        };

        menu.addAction(deleteAction);
        for (int i = 0; i < menu.toString().length(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select", range));
        } while (!"y".equals(this.input.ask("Exit ? y")));

    }


    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Action()).init();
    }
}
package eye.tracking.graph;

import eye.tracking.graph.input.Input;

public interface UserAction {

    int key();

    void execute(Input input, Action tracker);

    String info();
}
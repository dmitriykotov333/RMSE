package eye.tracking.graph;

import eye.tracking.graph.Action;
import eye.tracking.graph.ReadExcel;
import eye.tracking.graph.UserAction;
import eye.tracking.graph.input.Input;

import java.io.IOException;
import java.util.List;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;

    BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return name;
    }

    public ReadExcel getData(List<UserAction> userAction, Input input, Action action) throws IOException {
        System.out.println("------------ " + userAction.get(key()).info() + " --------------");
        String name = input.ask("Enter absolute path file xml : ");
        int predictedX = Integer.parseInt(input.ask("Enter the number of the column where the predicted\nvalues for by X are stored (numbering starts at 0) : "));
        int actualX = Integer.parseInt(input.ask("Enter the number of the column where the actual\nvalues for by X are stored (numbering starts at 0) : "));
        int predictedY = Integer.parseInt(input.ask("Enter the number of the column where the predicted\nvalues for by Y are stored (numbering starts at 0) : "));
        int actualY = Integer.parseInt(input.ask("Enter the number of the column where the actual\nvalues for by Y are stored (numbering starts at 0) : "));
        action.setPath(name);
        return action.readExcel(predictedX, predictedY, actualX, actualY);
    }
}

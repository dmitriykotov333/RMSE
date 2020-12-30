package eye.tracking.graph;

public enum EnumAction {
    NRMSE(0, "Calculate normalized root mean square error"),
    RMSE(1, "Calculate root mean square error"),
    ABS(2, "Calculate the absolute error"),
    ALL(3, "Calculate all"),
    ABOUT(4, "About"),
    TUTORIAL(5, "Tutorial");


    String menu;
    int key;

    EnumAction(int key, String menu) {
        this.key = key;
        this.menu = menu;

    }

}
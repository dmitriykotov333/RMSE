package eye.tracking.graph;


import eye.tracking.graph.input.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Menu {

    private Input input;
    private Action tracker;
    private List<UserAction> userAction = new ArrayList<>();

    public Menu(Input input, Action tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        userAction.add(new FirstAction(0, "Calculate normalized root mean square error"));
        userAction.add(new SecondAction(1, "Calculate root mean square error"));
        userAction.add(new ThirdAction(2, "Calculate the absolute error"));
        userAction.add(new FourthAction(3, "Calculate all"));
        userAction.add(new About(4, "About"));
        userAction.add(new Tutorial(5, "Tutorial"));
    }

    public void addAction(UserAction action) {
        this.userAction.add(action);
    }

    public void show() {
        for (EnumAction enumAction : EnumAction.values()) {
            System.out.println(enumAction.key + " : " + enumAction.menu);
        }
    }

    public void select(int key) {
        userAction.get(key).execute(input, tracker);
    }

    private class FirstAction extends BaseAction {


        FirstAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            try {
                ReadExcel readExcel = getData(userAction, input, tracker);
                System.out.println("---------------------------------------------------------------------");
                System.out.println(String.format("Result by X : %s %%\nResult by Y : %s %%",
                        tracker.nrmse(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.nrmse(readExcel.getPredictedByY(), readExcel.getActualByY())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private class SecondAction extends BaseAction {


        SecondAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            try {
                ReadExcel readExcel = getData(userAction, input, tracker);
                System.out.println("---------------------------------------------------------------------");
                System.out.println(String.format("Result by X : %s\nResult by Y : %s",
                        tracker.rmse(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.rmse(readExcel.getPredictedByY(), readExcel.getActualByY())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ThirdAction extends BaseAction {


        ThirdAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            try {
                ReadExcel readExcel = getData(userAction, input, tracker);
                System.out.println("---------------------------------------------------------------------");
                System.out.println(String.format("Result by X : %s\nResult by Y : %s",
                        tracker.abs(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.abs(readExcel.getPredictedByY(), readExcel.getActualByY())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class FourthAction extends BaseAction {


        FourthAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            try {
                ReadExcel readExcel = getData(userAction, input, tracker);
                System.out.println("---------------------------------------------------------------------");
                System.out.println(String.format("Normalized root mean square error\nResult by X : %s %%\nResult by Y : %s %%\n"
                                + "Root mean square error\nResult by X : %s\nResult by Y : %s\n"
                                + "Absolute error\nResult by X : %s\nResult by Y : %s\n",
                        tracker.nrmse(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.nrmse(readExcel.getPredictedByY(), readExcel.getActualByY()),
                        tracker.rmse(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.rmse(readExcel.getPredictedByY(), readExcel.getActualByY()),
                        tracker.abs(readExcel.getPredictedByX(), readExcel.getActualByX()),
                        tracker.abs(readExcel.getPredictedByY(), readExcel.getActualByY())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private class About extends BaseAction {


        About(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            System.out.println("This program is designed to find the calculate normalized root mean square error, root mean square error and absolute data error.\n" +
                    "Input data are files of an Excel table with arrays of data.");
        }
    }
    private class Tutorial extends BaseAction {


        Tutorial(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Action tracker) {
            System.out.println("1. Enter the full path to the file\nExample: " +
                    "C:\\Users\\PC_NAME\\Desktop\\file_name.xls");
            System.out.println("2. Next, you need to enter the index of the column in which the required data is located.\n" +
                    "What does 'predicted' and 'actual' mean, this is the data, for example, that you found manually, and actual this is the data that the program found");
        }
    }
}
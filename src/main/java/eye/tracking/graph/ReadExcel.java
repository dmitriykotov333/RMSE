package eye.tracking.graph;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {

    private List<Double> predictedByX;
    private List<Double> predictedByY;
    private List<Double> actualByX;
    private List<Double> actualByY;

    public ReadExcel(List<Double> predictedByX, List<Double> predictedByY, List<Double> actualByX, List<Double> actualByY) {
        this.predictedByX = predictedByX;
        this.predictedByY = predictedByY;
        this.actualByX = actualByX;
        this.actualByY = actualByY;
    }

    public List<Double> getPredictedByX() {
        return predictedByX;
    }

    public void setPredictedByX(List<Double> predictedByX) {
        this.predictedByX = predictedByX;
    }

    public List<Double> getPredictedByY() {
        return predictedByY;
    }

    public void setPredictedByY(List<Double> predictedByY) {
        this.predictedByY = predictedByY;
    }

    public List<Double> getActualByX() {
        return actualByX;
    }

    public void setActualByX(List<Double> actualByX) {
        this.actualByX = actualByX;
    }

    public List<Double> getActualByY() {
        return actualByY;
    }

    public void setActualByY(List<Double> actualByY) {
        this.actualByY = actualByY;
    }
}

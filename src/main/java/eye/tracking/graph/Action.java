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
import java.util.Arrays;
import java.util.List;

public class Action {

    /**
     * Normalized Root Mean Square Error
     *
     * @param value_exp
     * @param value_pr
     * @return result in percent
     */
    public double nrmse(List<Double> value_exp, List<Double> value_pr) {
        double bus = 0;
        double sum = 0;
        double result;
        for (int i = 0; i < value_pr.size() - 1; i++) {
            bus += Math.pow(value_pr.get(i) - value_exp.get(i), 2);
            sum += Math.pow(value_pr.get(i), 2);
        }
        result = Math.sqrt(bus / sum);
        return result * 100;
    }

    /**
     * Root Mean Square Error
     *
     * @param value_exp
     * @param value_pr
     * @return result
     */
    public double rmse(List<Double> value_exp, List<Double> value_pr) {
        double bus = 0;
        for (int i = 0; i < value_pr.size() - 1; i++) {
            bus += Math.pow(value_pr.get(i) - value_exp.get(i), 2);

        }
        return Math.sqrt(bus / value_pr.size() - 1);
    }


    public double abs(List<Double> value_pr, List<Double> value_exp) {
        double res = 0;
        for (int i = 0; i < value_exp.size() - 1; i++) {
            res += value_pr.get(i) - value_exp.get(i);
        }
        return res / value_pr.size() - 1;
    }

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


        //"C:/Users/dmitr/Desktop/EyeTrackingJava/src/main/resources/" + file + ".xls"


    public ReadExcel readExcel(int predicatedX, int predicatedY, int actualX, int actualY) throws IOException {

        FileInputStream  inputStream = new FileInputStream(new File(getPath()));
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFRow row;
        List<Double> actualByX = new ArrayList<Double>();
        List<Double> actualByY = new ArrayList<Double>();
        List<Double> predictedByX = new ArrayList<Double>();
        List<Double> predictedByY = new ArrayList<Double>();
        int j = 0;
        while (j < sheet.getLastRowNum()) {
            row = sheet.getRow(j);
            if (row.getCell(actualX).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                double value = row.getCell(0).getNumericCellValue();
                actualByX.add(value);
            }
            if (row.getCell(actualY).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                double value = row.getCell(1).getNumericCellValue();
                actualByY.add(value);
            }
            if (row.getCell(predicatedX).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                double value = row.getCell(2).getNumericCellValue();
                predictedByX.add(value);
            }
            if (row.getCell(predicatedY).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                double value = row.getCell(3).getNumericCellValue();
                predictedByY.add(value);
            }
            j++;
        }
        return new ReadExcel(predictedByX, predictedByY, actualByX, actualByY);
    }
}

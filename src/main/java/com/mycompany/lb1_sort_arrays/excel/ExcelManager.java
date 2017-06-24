
package com.mycompany.lb1_sort_arrays.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.charts.AxisCrosses;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * <p>The <code>ExcelManager</code> class designed for working whith excel. 
 * Write, read, draw charts and creates sheets.</p> 
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class ExcelManager {
    
    //model of excel document
    private Workbook workBook;
    //list of all sheets in document
    private ArrayList<Sheet> sheets;

    public ExcelManager() {
        workBook = new XSSFWorkbook();
        sheets = new ArrayList<>();
    }

    /**
     * Writing description for data vertically. Can be use like axis.
     * @param sheetName name of sheet in which to write descriprion
     * @param array array with description for data
     * @param x pointer on cell for start writing
     * @param y pointer on row for start writing
     * @throws IllegalArgumentException if param is incorect
     */
    public void writeVerticalDescInSheet(String sheetName, String[] array, int x, int y) {
        if (sheetName == null || array == null || sheetName.length() == 0
                || array.length == 0 || x < 0 || y < 0) {
            throw new IllegalArgumentException("sheetName == null || array == null || " 
                    + "sheetName.length() == 0 || array.length == 0 || x < 0 || y < 0");
        }

        for (Sheet sheet : sheets) {
            if (sheet.getSheetName().equals(sheetName)) {
                Row row;
                Cell cell;
                for (int i = y; i < array.length + y; i++) {
                    row = sheet.createRow(i);
                    cell = row.createCell(x);
                    cell.setCellValue(array[i - y]);
                }
            }
        }        
    }

    /**
     * Writing description for data horizontally.
     * @param sheetName name of sheet in which to write descriprion
     * @param array array with description for data
     * @param x pointer on cell for start writing
     * @param y pointer on row for start writing
     * @throws IllegalArgumentException if param is incorect
     */
    public void writeHorizontalDescInSheet(String sheetName, String[] array, int x, int y) {
        if (sheetName == null || array == null || sheetName.length() == 0
                || array.length == 0 || x < 0 || y < 0) {
            throw new IllegalArgumentException("sheetName == null || array == null || " +
                            "sheetName.length() == 0 || array.length == 0 || x < 0 || y < 0");
        }
        for (Sheet sheet : sheets) {
            if (sheet.getSheetName().equals(sheetName)) {
                Row row = sheet.createRow(y);
                Cell cell;
                for (int i = x; i < array.length + x; i++) {                    
                    cell = row.createCell(i);                    
                    cell.setCellValue(array[i - x]);
                }
            }
        }        
    }
    
    /**
     * Writing numbers into sheet for coordinates.
     * @param sheetName name of sheet in which to write
     * @param array array with data
     * @param x pointer on cell for start writing
     * @param y pointer on row for start writing
     * @throws IllegalArgumentException if param is incorect
     */
    public void writeArrayInSheet(String sheetName, long[][] array, int x, int y) {
        if (sheetName == null || array == null || sheetName.length() == 0
                || array.length == 0 || x < 0 || y < 0) {
            throw new IllegalArgumentException("sheetName == null || array == null || " +
                         "sheetName.length() == 0 || array.length == 0 || x < 0 || y < 0");
        }        
        for (Sheet sheet : sheets) {
            if (sheet.getSheetName().equals(sheetName)) {
                for (int i = y; i < array.length + y; i++) {
                    Row row = sheet.getRow(i);                    
                    long[] cellsArray = array[i - y];
                    for (int j = x; j < cellsArray.length + x; j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(cellsArray[j - x]);
                    }
                }
            }
        }        
    }

    /**
     * Create new sheet in the excel document
     * @param sheetName names of new sheet
     * @throws IllegalArgumentException if param is incorect
     */
    public void addSheet(String sheetName) {
        if (sheetName == null || sheetName.length() == 0) {
            throw new IllegalArgumentException("sheetName == null || sheetName.length() == 0");
        }
        Sheet sheet = workBook.createSheet(sheetName);
        sheets.add(sheet);        
    }
    
    /**
     * Write model document to a file by the path
     * @param filePath path to file
     * @throws IllegalArgumentException if param is incorect
     */
    public void flush(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            throw new IllegalArgumentException("filePath == null || filePath.length() == 0");
        }
        try (FileOutputStream fo = new FileOutputStream(filePath);) {
            workBook.write(fo);
            workBook.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelManager.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    /**
     * <p>Draws graphic\graphics by coordinates. Depending on the specified 
     * width data set on one canvas can draw as one or several charts. 
     * Count of charts is <code>heightData-y</code></p>
     * @param sheetName sheet name which should draw chart
     * @param y pointer on row when starting data
     * @param x pointer on cell when starting data
     * @param heightData length of array data on which we must draw chart
     * @param weightData weight of array data on which we must draw chart
     * @throws IllegalArgumentException if param is incorect
     */
    public void drawChart(String sheetName, int y, int x, int heightData, int weightData) {
        if (sheetName == null || sheetName.length() == 0 || x < 0 
                        || y < 0 || heightData < 0 || weightData < 0) {
            throw new IllegalArgumentException("sheetName == null || sheetName.length() == 0 " +
                         "|| x < 0 || y < 0 || heightData < 0 || weightData < 0");
        }
        
        for (Sheet sheet : sheets) {
            if (sheet.getSheetName().equals(sheetName)) {

                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 7, 18, 28);

                Chart chart = drawing.createChart(anchor);
                ChartLegend legend = chart.getOrCreateLegend();
                legend.setPosition(LegendPosition.TOP_RIGHT);

                LineChartData data = chart.getChartDataFactory().createLineChartData();

                // Use a category axis for the bottom axis.
                ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
                ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
                leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

                ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(y, y, x, weightData));

                for (int i = y + 1; i <= heightData; i++) {
                    ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(i, i, x, weightData));
                    data.addSeries(xs, ys1);
                }

                chart.plot(data, bottomAxis, leftAxis);
            }
        }        
    }
}

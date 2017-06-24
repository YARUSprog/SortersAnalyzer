
package com.mycompany.lb1_sort_arrays.analyzer;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.lb1_sort_arrays.LB1_Sort_arrays;
import com.mycompany.lb1_sort_arrays.excel.ExcelManager;
import com.mycompany.lb1_sort_arrays.fillers.Generator;
import com.mycompany.lb1_sort_arrays.sorters.Sorter;

/**
 * <p>The <code>Analyzer</code> class designed to speed sorting statistics on 
 * different types of arrays and depending on the size. </p>
 * @see com.mycompany.lb1_sort_arrays.fillers.ArraysGenerator
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergeSort
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class Analyzer {
    
    //the minimum size of the array
    private static final int MIN_SIZE = 10;
    //count of sorters
    private static int ROWS_SIZE;    
    //count of arrays of each type. 
    //At multiplying by MIN_SIZE at each iteration we get the size of the array
    private static final int CELLS_SIZE = 4;
    //Path to file with statistics
    private static final String filePath = "D:/Лаба_1_Курси.xlsx";
    
    //for work with reflection
    private Reflections reflect;
    //for work with excel file
    private ExcelManager excelManager;     
    //singlton    
    public static Analyzer instance;
    
    private Analyzer() {
        reflect = new Reflections();
        excelManager = new ExcelManager();                
    }

    public static synchronized Analyzer getInstance() {
        if (instance == null) {
            instance = new Analyzer();
        }
        return instance;
    }
    /**
     * Starting calculations.
     */
    public void start() {
        List sorters = reflect.getObjectsSubclasses(Sorter.class.getPackage().getName(), Sorter.class.getCanonicalName());
        List<Generator> generators = reflect.getObjectsImplementers(LB1_Sort_arrays.class.getPackage().getName(), "Generator");
        getStatistics(generators, sorters);
    }

    /**
     * <p>He takes all methods of sorting facilities for sorting. He takes all 
     * methods generate arrays each class generator. Each got sorting sorts 
     * each type of array. It takes several different sizes for each array.
     * Measure each sort. Writes data to a xlsx file on a separate tab for each sort.
     * On each tab draws graphics sorting speed change depending on changes in 
     * the size of the array. For every sort - his graphic</p>
     * @param generators list of objects that generate arrays
     * @param sorters list of objects that are sorted arrays
     */
    public void getStatistics(List<Generator> generators, List<Sorter> sorters) {
        ROWS_SIZE = sorters.size();
        long[][] timeArray = new long[ROWS_SIZE][CELLS_SIZE]; //buffer for result time
        String[] verticalDesc = new String[ROWS_SIZE];          //buufer for vertical description in table
        String[] horizontalDesc = new String[CELLS_SIZE];      //buufer for horizontal description in table
        long start = 0, finish = 0, timeConsumedMillis = 0; //for time dimension of sorting
        int[] arrayForSort; //temp array for sorting arrays        
        for (Generator gen : generators) {            
            Method[] methods = gen.getClass().getDeclaredMethods();            
            for (int i = 0; i < methods.length; i++) {
                Method m = methods[i];
                Annotation[] annotations = m.getAnnotations();
                for (Annotation an : annotations) {
                    if (an.annotationType().getSimpleName().equals("ToGenerateIntegerArray")) {                        
                        for (int j = 0; j < sorters.size(); j++) {                            
                            Sorter sorter = sorters.get(j);
                            try {                                
                                verticalDesc[j] = sorter.getClass().getSimpleName();                                
                                for (int k = 0, count = MIN_SIZE; count <= Math.pow(MIN_SIZE, CELLS_SIZE); k++, count *= MIN_SIZE) {
                                    horizontalDesc[k] = count+"";                                    
                                    arrayForSort = (int[]) m.invoke(gen, count);                                                                        
                                    start = System.nanoTime();
                                    sorter.sort(arrayForSort);
                                    finish = System.nanoTime();
                                    timeConsumedMillis = finish - start;
                                    timeArray[j][k] = timeConsumedMillis;
                                }
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalArgumentException ex) {
                                Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InvocationTargetException ex) {
                                Logger.getLogger(LB1_Sort_arrays.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        excelManager.addSheet(m.getName());
                        excelManager.writeHorizontalDescInSheet(m.getName(), horizontalDesc, 1, 0);
                        excelManager.writeVerticalDescInSheet(m.getName(), verticalDesc, 0, 1);
                        excelManager.writeArrayInSheet(m.getName(), timeArray, 1, 1);                        
                        excelManager.drawChart(m.getName(), 0, 1, ROWS_SIZE, CELLS_SIZE);
                    }
                }
            }
        }
        excelManager.flush(filePath);        
    }
}

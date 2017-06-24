/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lb1_sort_arrays.excel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author YARUS
 */
public class ExcelManagerTest {
    
    public ExcelManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of writeVerticalDescInSheet method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWriteVerticalDescInSheetInputBadParams() {
        System.out.println("writeVerticalDescInSheet");
        String sheetName = "";
        String[] array = null;
        int x = 0;
        int y = 0;
        ExcelManager instance = new ExcelManager();
        instance.writeVerticalDescInSheet(sheetName, array, x, y);      
    }
    
    /**
     * Test of writeHorizontalDescInSheet method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWriteHorizontalDescInSheetInputBadParams() {
        System.out.println("writeHorizontalDescInSheet");
        String sheetName = "";
        String[] array = null;
        int x = 0;
        int y = 0;
        ExcelManager instance = new ExcelManager();
        instance.writeHorizontalDescInSheet(sheetName, array, x, y);
    }
    
    /**
     * Test of writeArrayInSheet method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testWriteArrayInSheetInputBadParams() {
        System.out.println("writeArrayInSheet");
        String sheetName = "";
        long[][] array = null;
        int x = 0;
        int y = 0;
        ExcelManager instance = new ExcelManager();
        instance.writeArrayInSheet(sheetName, array, x, y);
    }
    
    /**
     * Test of addSheet method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testAddSheetInputBadParams() {
        System.out.println("addSheet");
        String sheetName = "";
        ExcelManager instance = new ExcelManager();
        instance.addSheet(sheetName);
    }
    
    /**
     * Test of flush method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testFlushInputBadParams() {
        System.out.println("flush");
        String filePath = "";
        ExcelManager instance = new ExcelManager();
        instance.flush(filePath);
    }
    
    /**
     * Test of drawChart method, of class ExcelManager.
     * fail - If has taken bad params and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testDrawChartInputBadParams() {
        System.out.println("drawChart");
        String sheetName = "";
        int y = 0;
        int x = 0;
        int heightData = 0;
        int weightData = 0;
        ExcelManager instance = new ExcelManager();
        instance.drawChart(sheetName, y, x, heightData, weightData);
    }
}

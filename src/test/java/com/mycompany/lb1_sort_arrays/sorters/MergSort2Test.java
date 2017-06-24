/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lb1_sort_arrays.sorters;

import java.util.Arrays;
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
public class MergSort2Test {
    
    public MergSort2Test() {
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
     * Test of sort method, of class MergSort2.
     * fail - If sorting has taken null or 0 and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testSortInputNullorZero() {
        System.out.println("sort");
        MergSort2 instance = new MergSort2();
        instance.sort(null);
        int[] array = new int[5];
        instance.sort(array);        
    }

    /**
     * Test of sort method, of class MergSort2.
     * fail - If sorting changed data in the array
     */
    @org.junit.Test
    public void testSortDataChange() {
        System.out.println("sort");
        int[] array = {3, 1, 1, 5, 2};        
        int[] array2 ={1, 1, 2, 3, 5};        
        MergSort2 sorter = new MergSort2();
        sorter.sort(array);
        System.out.println("Must be:    " + Arrays.toString(array));
        System.out.println("But we get: " + Arrays.toString(array2));
        boolean fail = false;
        for(int i = 0; i < array.length; i++){            
            if(array[i] != array2[i]){
                fail = true;
            }           
        }    
        assertFalse("Array elements have changed", fail);            
    }
    
    /**
     * Test of sort method, of class MergSort2.
     * fail - if sorting is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testSortShortTime() {
        System.out.println("sort");
        MergSort2 instance = new MergSort2();
        int[] array = {1,3,5,2};        
        instance.sort(array);
    }
    
    /**
     * Test of sort method, of class MergSort2.
     * fail - if the data is sorted incorrectly
     */
    @org.junit.Test
    public void testSort() {
        System.out.println("sort");        
        int[] array = {1, -1, 1, -1};        
        int[] array2 ={-1, -1, 1, 1}; 
        MergSort2 sorter = new MergSort2();
        sorter.sort(array);
        System.out.println("Must be: " + Arrays.toString(array2));
        System.out.println("We get:  " + Arrays.toString(array));
        boolean fail = false;
        for(int i = 0; i < array.length; i++){            
            if(array[i] != array2[i]){
                fail = true;
            }           
        }    
        assertFalse("The data is sorted incorrectly", fail);            
    }
    
}

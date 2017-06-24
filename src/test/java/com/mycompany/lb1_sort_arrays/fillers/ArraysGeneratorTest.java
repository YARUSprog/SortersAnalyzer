/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lb1_sort_arrays.fillers;

import com.mycompany.lb1_sort_arrays.sorters.BubleSortFromFirst;
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
public class ArraysGeneratorTest {
    
    public ArraysGeneratorTest() {
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
     * Test of createRandomArray method, of class ArraysGenerator.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testCreateRandomArrayTime() {
        System.out.println("CreateRandomArray");
        int count = 5;        
        int[] result = ArraysGenerator.createRandomArray(count);
    }
    
    /**
     * Test of CreateRandomArray method, of class ArraysGenerator.
     * fail - If generator has taken number <= 0 and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCreateRandomArrayInputZeroOrLess() {
        System.out.println("CreateRandomArray");
        int count = -1;        
        int[] result = ArraysGenerator.createRandomArray(count);                               
    }
        
    /**
     * Test of createRandomArray method, of class ArraysGenerator.
     * fail - if length array != count (input parameter)
     */
    @Test
    public void testCreateRandomArraySize() {
        System.out.println("createRandomArray");
        int count = 5;           
        int[] result = ArraysGenerator.createRandomArray(count);        
        String error = "The length of the array generated incorrect";        
        assertEquals(error ,result.length, count);               
    }

    /**
     * Test of createSortedArray method, of class ArraysGenerator.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testCreateSortedArrayTime() {
        System.out.println("createSortedArray");
        int count = 5;        
        int[] result = ArraysGenerator.createSortedArray(count);
    }
    
    /**
     * Test of createSortedArray method, of class ArraysGenerator.
     * fail - If generator has taken number <= 0 and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCreateSortedArrayInputZeroOrLess() {
        System.out.println("createSortedArray");
        int count = -1;        
        int[] result = ArraysGenerator.createSortedArray(count);                               
    }
    
    /**
     * Test of createSortedArray method, of class ArraysGenerator.
     */
    @Test
    public void testCreateSortedArray() {
        System.out.println("createSortedArray");
        int count = 5;
        int[] mustResult = {0, 1, 2, 3, 4};        
        int[] result = ArraysGenerator.createSortedArray(count);        
        String error = "Must be:    " + Arrays.toString(mustResult) + "\nBut we get: " + Arrays.toString(result);        
        assertArrayEquals(error ,result, mustResult);               
    }
    
    /**
     * Test of createSortedArray method, of class ArraysGenerator.
     * fail - if length array != count (input parameter)
     */
    @Test
    public void testCreateSortedArraySize() {
        System.out.println("createSortedArray");
        int count = 5;           
        int[] result = ArraysGenerator.createSortedArray(count);        
        String error = "The length of the array generated incorrect";        
        assertEquals(error ,result.length, count);               
    }
    
    /**
     * Test of createInvertedSortedArray method, of class ArraysGenerator.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testCreateInvertedSortedArrayTime() {
        System.out.println("createInvertedSortedArray");
        int count = 5;        
        int[] result = ArraysGenerator.createInvertedSortedArray(count);
    }
    
    
    /**
     * Test of createInvertedSortedArray method, of class ArraysGenerator.
     * fail - If generator has taken number <= 0 and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCreateInvertedSortedArrayInputZeroOrLess() {
        System.out.println("CreateInvertedSortedArray");
        int count = -1;        
        int[] result = ArraysGenerator.createInvertedSortedArray(count);                               
    }

    /**
     * Test of createInvertedSortedArray method, of class ArraysGenerator.
     */
    @Test
    public void testCreateInvertedSortedArray() {
        System.out.println("createInvertedSortedArray");
        int count = 5;
        int[] mustResult = {4, 3, 2, 1, 0};        
        int[] result = ArraysGenerator.createInvertedSortedArray(count);        
        String error = "Must be:    " + Arrays.toString(mustResult) + "\nBut we get: " + Arrays.toString(result);        
        assertArrayEquals(error ,result, mustResult);
    }
    
    /**
     * Test of createInvertedSortedArray method, of class ArraysGenerator.
     * fail - if length array != count (input parameter)
     */
    @Test
    public void testSizeOfCreateInvertedSortedArray() {
        System.out.println("createInvertedSortedArray");
        int count = 5;           
        int[] result = ArraysGenerator.createInvertedSortedArray(count);        
        String error = "The length of the array generated incorrect";        
        assertEquals(error ,result.length, count);               
    }

    /**
     * Test of createSortedArrayWithRand method, of class ArraysGenerator.
     * fail - if generating is done too slowly
     */
    @org.junit.Test(timeout = Long.MIN_VALUE)
    public void testCreateSortedArrayWithRandTime() {
        System.out.println("createInvertedSortedArray");
        int count = 5;        
        int[] result = ArraysGenerator.createSortedArrayWithRand(count);
    }
    
    /**
     * Test of createSortedArrayWithRand method, of class ArraysGenerator.
     * fail - If generator has taken number <= 0 and not throw exception
     */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testCreateSortedArrayWithRandInputZeroOrLess() {
        System.out.println("createSortedArrayWithRand");
        int count = -1;        
        int[] result = ArraysGenerator.createSortedArrayWithRand(count);                               
    }
    
    /**
     * Test of createSortedArrayWithRand method, of class ArraysGenerator.
     * fail - if any item is generated out of order (except the last)
     */
    @Test
    public void testCreateSortedArrayWithRand() {
        System.out.println("createSortedArrayWithRand");
        int count = 5;
        int[] mustResult = {0, 1, 2, 3};        
        int[] result = ArraysGenerator.createSortedArrayWithRand(count);        
        boolean fail = false;
        for(int i = 0; i < mustResult.length-1; i++){
            if(result[i] != mustResult[i]){
                fail = true;
            }
        }
        String error = "Must be:    " + Arrays.toString(mustResult) + "\nBut we get: " + Arrays.toString(result);        
        assertFalse(error ,fail);
    }
    
    /**
     * Test of createSortedArrayWithRand method, of class ArraysGenerator.
     * fail - if length array != count (input parameter)
     */
    @Test
    public void testSizeOfCreateSortedArrayWithRand() {
        System.out.println("createSortedArrayWithRand");
        int count = 5;           
        int[] result = ArraysGenerator.createSortedArrayWithRand(count);        
        String error = "The length of the array generated incorrect";        
        assertEquals(error ,result.length, count);               
    }
}

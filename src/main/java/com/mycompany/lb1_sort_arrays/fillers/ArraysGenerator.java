
package com.mycompany.lb1_sort_arrays.fillers;

import java.util.Random;

/**
 * The <code>ArraysGenerator</code> class designed for generating arrays.
 * @author  YARUS
 */
public class ArraysGenerator implements Generator{

    public ArraysGenerator() {
    }
    
    /**
     * Generates integer array with random elements in the range of 1 to 100.  
     * @param count size of the array that will be generated
     * @return integer array
     */
    @ToGenerateIntegerArray
    public static int[] createRandomArray(int count){
        if(count <= 0){
            throw new IllegalArgumentException("count <= 0");
        }
        int[] array = new int[count];
        Random r = new Random();
        for(int i = 0; i < count; i++){
            array[i] = r.nextInt(100);
        }
        return array;
    }
    
    /**
     * Generates integer sorted array.  
     * @param count size of the array that will be generated
     * @return integer array
     */
    @ToGenerateIntegerArray
    public static int[] createSortedArray(int count){
        if(count <= 0){
            throw new IllegalArgumentException("count <= 0");
        }
        
        int[] array = new int[count];        
        for(int i = 0; i < count; i++){
            array[i] = i;
        }
        return array;
    }
    
    /**
     * Generates sorted array in reverse order.  
     * @param count size of the array that will be generated
     * @return integer array
     */
    @ToGenerateIntegerArray
    public static int[] createInvertedSortedArray(int count){
        if(count <= 0){
            throw new IllegalArgumentException("count <= 0");
        }
        int[] array = new int[count];        
        for(int i = count-1, j = 0; i >= 0; i--, j++){
            array[j] = i;
        }
        return array;
    }
    
    /**
     * Generates sorted array with random last element.  
     * @param count size of the array that will be generated
     * @return integer array
     */
    @ToGenerateIntegerArray
    public static int[] createSortedArrayWithRand(int count){
        if(count <= 0){
            throw new IllegalArgumentException("count <= 0");
        }
        int[] array = new int[count];        
        Random r = new Random();
        for(int i = 0; i < count-1; i++){
            array[i] = i;
        }
        array[count-1] = r.nextInt(100);
        return array;
    }
}

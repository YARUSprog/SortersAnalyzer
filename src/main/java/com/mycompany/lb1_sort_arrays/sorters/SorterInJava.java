/**
 * The <code>SorterInJava</code> class designed for sorting array 
 * by Arrays.sort() method. 
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort 
 * @since Java_8
 * @author  Musienko Yaroslav
 */
package com.mycompany.lb1_sort_arrays.sorters;

import java.util.Arrays;

/**
 *
 * @author YARUS
 */
public class SorterInJava extends Sorter{
    /**
     * Sorts integer array by Arrays.sort() method.
     * @param array - input array that you want to sort
     */
    @Override
    public void sort(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        Arrays.sort(array);
        
    }
}

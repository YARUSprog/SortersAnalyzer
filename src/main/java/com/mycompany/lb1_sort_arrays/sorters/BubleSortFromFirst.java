
package com.mycompany.lb1_sort_arrays.sorters;

import java.lang.IllegalArgumentException;

/**
 * The <code>BubleSortFromFirst</code> class designed for sorting array 
 * by bubbles method, from first element in array. 
 * <p>See also a similar class {@link com.mycompany.lb1_sort_arrays.sorters.BubleSortFromLast}</p>
 * @deprecated - sorts slow, use the {@link com.mycompany.lb1_sort_arrays.sorters.QuickSort}
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergeSort
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class BubleSortFromFirst extends Sorter {
    /**
     * Sorts integer array by bubbles from first element.
     * @param array input array that you want to sort     
     */
    @Override 
    public void sort(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        int out, in;
        for(out = array.length-1; out > 0; out--){ 
            for(in = 0; in < out; in++){ 
                if( array[in] > array[in+1] ){
                    swap(array, in, in+1); 
                }
            }
        }
    }    
}

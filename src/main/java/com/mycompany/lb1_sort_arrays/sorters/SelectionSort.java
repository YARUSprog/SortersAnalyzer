
package com.mycompany.lb1_sort_arrays.sorters;

/**
 * The <code>SelectionSort</code> class designed for sorting array 
 * by selection method.
 * @deprecated - sorts slow, use the {@link com.mycompany.lb1_sort_arrays.sorters.QuickSort}
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergeSort
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class SelectionSort extends Sorter{
    /**
     * Sorts integer array by selection method.
     * @param array - input array that you want to sort
     */
    @Override
    public void sort(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        int out, in, min;
        for(out = 0; out < array.length-1; out++){
            min = out;
            for(in = out+1; in < array.length; in++){ 
                if(array[in] < array[min] ){
                    min = in;
                }
            }
            swap(array, out, min);
        }
    }
}

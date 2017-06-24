
package com.mycompany.lb1_sort_arrays.sorters;

/**
 * The <code>Sorter</code> class designed for sorting array.
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public abstract class Sorter {
    /**
     * Sorts integer array.  
     * @param array - input array that you want to sort
     */
    public void sort(int[] array){}
    
    /**
     * Swap two element arrays on indices.
     * @param array - input array in that you want swap elements.
     * @param one - index of the first element of the array to swap
     * @param two - index of the second element of the array to swap
     */
    protected void swap(int[] array, int one, int two){
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}

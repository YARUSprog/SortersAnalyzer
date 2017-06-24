
package com.mycompany.lb1_sort_arrays.sorters;

/**
 * The <code>MergeSort</code> class designed for sorting array by merge method.
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergSort2
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class MergeSort extends Sorter{
    /**
     * Sorts integer array breaking it in two. 
     * Sorts each part separately and merge them.
     * @param array - input array that you want to sort     * 
     */
    @Override
    public void sort(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        int[] a = new int[array.length/2];
        int[] b = new int[array.length - a.length];        
        System.arraycopy(array, 0, a, 0, a.length);
        System.arraycopy(array, a.length, b, 0, b.length);
        SelectionSort sr = new SelectionSort();
        sr.sort(a);
        sr.sort(b);        
        merge(a, b, array);        
    }
    
    /**
     * Merges two integer arrays. If the input arrays sorted - get a sorted array,</br>
     * if no - not sorted. 
     * @param arrayA first input sorted array
     * @param arrayB second input sorted array
     * @param arrayC the resulting array which consist with merged {@code arrayA} and {@code arrayB}
     */
    private void merge( int[] arrayA, int[] arrayB, int[] arrayC){            
        int aDex=0, bDex=0, cDex=0;
        while(aDex < arrayA.length && bDex < arrayB.length) 
            if( arrayA[aDex] < arrayB[bDex] )
                arrayC[cDex++] = arrayA[aDex++];
            else
                arrayC[cDex++] = arrayB[bDex++];
        while(aDex < arrayA.length) 
            arrayC[cDex++] = arrayA[aDex++]; 
        while(bDex < arrayB.length) 
            arrayC[cDex++] = arrayB[bDex++]; 
    }
}

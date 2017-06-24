
package com.mycompany.lb1_sort_arrays.sorters;

/**
 * The <code>MergeSort2</code> class designed for sorting array 
 * by merge method.
 * @see com.mycompany.lb1_sort_arrays.sorters.QuickSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergeSort
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class MergSort2 extends Sorter{
    /**
     * Need like buffer for sorting
     * @author  Musienko Yaroslav
     */
    private static int[] workSpace;
    
    /**
     * Sorts integer array by classic merge method.  
     * @param array - input array that you want to sort  
     */
    @Override
    public void sort(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        workSpace = new int[array.length];;
        recMergeSort(array, 0, array.length-1);
    }
    
    /**
     * Recursively sorts the array in transferred within.  
     * @param array - input array that you want to sort
     * @param lowerBound the lower limit of the array to sort
     * @param upperBound the upper limit of the array to sort
     */
    private void recMergeSort(int[] array, int lowerBound, int upperBound){
        if(lowerBound == upperBound) 
            return; 
        else{ // Поиск середины
            int mid = (lowerBound+upperBound) / 2;
            // Сортировка нижней половины
            recMergeSort(array, lowerBound, mid);
            // Сортировка верхней половины
            recMergeSort(array, mid+1, upperBound);
            // Слияние
            merge(array, lowerBound, mid+1, upperBound);
        }
    }
    
    /**
     * Merge two segments array. .  
     * @param array - input array in which you want to merge two segments
     * @param lowerBound the lower limit of the array to merge
     * @param highPtr limit of two segments in the array
     * @param upperBound the upper limit of the array to merge
     */
    private void merge(int[] array, int lowPtr, int highPtr, int upperBound){        
        int j = 0; // Индекс в рабочей области
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // Количество элементов
        while(lowPtr <= mid && highPtr <= upperBound)
            if( array[lowPtr] < array[highPtr] )
                workSpace[j++] = array[lowPtr++];
            else
                workSpace[j++] = array[highPtr++];
            while(lowPtr <= mid)
                workSpace[j++] = array[lowPtr++];
            while(highPtr <= upperBound)
                workSpace[j++] = array[highPtr++];
            for(j=0; j<n; j++)
                array[lowerBound+j] = workSpace[j];
    }
}

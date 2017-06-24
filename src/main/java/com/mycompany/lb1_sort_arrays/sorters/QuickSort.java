package com.mycompany.lb1_sort_arrays.sorters;

/**
 * The <code>QuickSort</code> class designed for sorting array by "quick sort"
 * method.
 *
 * @see com.mycompany.lb1_sort_arrays.sorters.MergeSort
 * @see com.mycompany.lb1_sort_arrays.sorters.MergSort2
 * @since Java_8
 * @author  Musienko Yaroslav
 */
public class QuickSort extends Sorter {

    /**
     * Sort integer array by recursive quicksort.
     *
     * @param array - input array that you want to sort
     */
    @Override
    public void sort(int[] array) {
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0");
        }
        recQuickSort(array, 0, array.length - 1);
    }

    /**
     * Recursively sorts the array in transferred within.
     *
     * @param array - input array that you want to sort
     * @param left the lower limit of the array to sort
     * @param right the upper limit of the array to sort
     */
    private void recQuickSort(int[] array, int left, int right) {
        int size = right - left + 1;        
        if (size < 10) {
            insertionSort(array, left, right);            
        } else {// Для размера 2 и более
            int median = medianOf3(array, left, right); // Крайний правый элемент
            // Разбиение диапазона
            int partition = partition(array, left, right, median);
            recQuickSort(array, left, partition - 1); // Сортировка левой части
            recQuickSort(array, partition + 1, right); // Сортировка правой части
        }
    }

    /**
     * Breakdown array into two parts relative to the base element. At the left
     * side are all elements that are smaller than the median, and the right -
     * more than the median.
     *
     * @param array input array in which you want to partition the segment
     * @param left the lower limit of the array to partition
     * @param right the upper limit of the array to partition
     * @param median value on which segment will be partition
     * @return a pointer (integer value) to the location of the median
     */
    private int partition(int[] array, int left, int right, int median) {
        int leftPtr = left - 1; //левий елемент
        int rightPtr = right; //правий елемент
        while (true) {
            while (array[++leftPtr] < median);  //поиск неправильного значения в левой части     
            while (rightPtr > 0 && array[--rightPtr] > median); //поиск неправильно в правой
            if (leftPtr >= rightPtr) //если указатели встритились - розбиение закончено
            {
                break;
            } else {
                swap(array, leftPtr, rightPtr);
            }
        }
        swap(array, leftPtr, right); // перемещение опорного елемента на свое место
        return leftPtr; //конечная позиция 
    }

    private int medianOf3(int[] array, int left, int right) {
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array == null || array.length == 0 ");
        }
        
        int center = (left + right) / 2;
        // Упорядочение left и center
        if (array[left] > array[center]) {
            swap(array, left, center);
        }
        // Упорядочение left и right
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        // Упорядочение center и right
        if (array[center] > array[right]) {
            swap(array, center, right);
        }
        swap(array, center, right - 1); // Размещение медианы на правом краю
        return array[right - 1]; // Метод возвращает медиану
    }

    private void insertionSort(int[] array, int left, int right) {
        int in, out;        
        for (out = left + 1; out <= right; out++) {
            int temp = array[out]; 
            in = out;            
            while (in > left && array[in - 1] >= temp) {
                array[in] = array[in - 1];
                --in;
            }
            array[in] = temp;
        }
    }
}

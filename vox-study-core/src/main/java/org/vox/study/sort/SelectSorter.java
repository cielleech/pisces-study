package org.vox.study.sort;

import java.util.Random;

/**
 * 
 * @author rookie.lee
 *
 * @param <T>
 */
public class SelectSorter<T extends Comparable<T>> implements Sorter<T> {

    /*
     * (non-Javadoc)
     * @see org.vox.study.sort.Sorter#sort(java.util.Comparator[])
     */
    @Override
    public void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i; j < array.length; j++) {
                if (array[index].compareTo(array[j]) > 0) {
                    index = j;
                }
            }
            
            swap(array, i, index);
        }
    }
    
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void main(String[] args) {
        Integer[] array = new Integer[100];
        
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length * 31);
        }
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        
        System.out.println("");
        
        Sorter<Integer> sorter = new SelectSorter<>();
        sorter.sort(array);
        
                for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

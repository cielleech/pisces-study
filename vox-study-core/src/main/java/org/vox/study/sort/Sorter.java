package org.vox.study.sort;

/**
 * 
 * @author rookie.lee
 *
 */
public interface Sorter<T extends Comparable<T>> {
    /**
     * Sort the argument array.
     * 
     * @param array
     */
    void sort(T[] array);
}

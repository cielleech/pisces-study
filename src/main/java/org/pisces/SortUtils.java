package org.pisces.study.sort;

import java.util.Random;

public class SortUtils {
    public static void main(String[] args) {
        SortUtils utils = new SortUtils();
        Integer[] unsorts = new Integer[50];

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            unsorts[i] = random.nextInt();
        }

        for (int i = 0; i < 50; i++) {
            System.out.print(unsorts[i] + " ");
        }

        System.out.print("\n********************\n");

        Integer[] result = utils.insertSort(unsorts);

        for (int i = 0; i < 50; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private <T extends Comparable> T[] insertSort(T[] array) {
        for (int i = 0; i < 50; i++) {
            int j = i;
            T target = array[i];

            while (j > 0 && target.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = target;
        }
        return array;
    }

    private Integer[] insertSort() {
        Integer[] unsorts = new Integer[50];

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            unsorts[i] = random.nextInt();
        }

        Integer[] result = insertSort(unsorts);


        System.out.println(result);

        return null;
    }
}
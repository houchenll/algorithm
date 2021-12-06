package com.hc.algorithm.main.sort;

import com.hc.algorithm.main.array.ArrayTool;

public class TestSort {

    public static void main(String[] args) {
        int[] array = ArrayTool.genArray(10);
        ArrayTool.printArray(array);

        Sort sort = new QuickSort();
        long start = System.nanoTime();
        sort.sort(array);

        long duration = System.nanoTime() - start;
        System.out.println(duration);
        ArrayTool.printArray(array);
    }

}

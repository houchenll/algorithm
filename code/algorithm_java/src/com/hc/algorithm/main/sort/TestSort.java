package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.ArrayTool;
import com.hc.algorithm.util.PrintUtil;
import com.hc.algorithm.util.Tool;

public class TestSort {

    public static void main(String[] args) {
//        Sort sort = new MaxHeapSort();
//        Sort sort = new QuickSort();
//        Sort sort = new MergeSort();
        Sort sort = new InsertionSort();

        TestSort test = new TestSort();
//        test.sort(sort, 100);
        test.sortOnce(sort);
    }

    private void sort(Sort sort, int repeatTimes) {
        long totalTime = 0;
        for (int i = 0; i < repeatTimes; i++) {
            int[] array = ArrayTool.genArray(100);
            totalTime += sortOneTime(sort, array);
        }
        long duration = totalTime / repeatTimes;
        System.out.println("average duration " + duration);
    }

    private void sortOnce(Sort sort) {
        int[] array = ArrayTool.genArray(10);
        PrintUtil.printIntArray(array, "origin array: ");

        sort.sort(array);

        PrintUtil.printIntArray(array, "sorted array: ");
    }

    private long sortOneTime(Sort sort, int[] array) {
//        ArrayTool.printArray(array);
        long start = System.nanoTime();
        sort.sort(array);
        long duration = System.nanoTime() - start;
//        System.out.println("one duration: " + duration);
//        ArrayTool.printArray(array);
        return duration;
    }

}

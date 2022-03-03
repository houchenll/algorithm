package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.ArrayTool;

public class TestSort {

    public static void main(String[] args) {
//        Sort sort = new MaxHeapSort();
//        Sort sort = new QuickSort();
        Sort sort = new MergeSort();

        TestSort test = new TestSort();
        test.sort(sort, 100);
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

package com.hc.algorithm.main.sort;

import com.hc.algorithm.util.Tool;

/**
 * 堆排序
 * 100个数字平均排序耗时25 515ns
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 缺点：性能不如快速排序，因为堆排序调整时，是在数组中跳跃取数调整，距离可能很远，不在一个块中，
 * 对cpu cache不友好，而快速排序调整的数字在数组中相邻不远，是局部顺序访问的
 * 在通常应用中，快排优于堆排序
 */
public class MaxHeapSort implements Sort {

    @Override
    public void sort(int[] nums) {
        maxHeapSort(nums);
    }

    private void maxHeapSort(int[] nums) {
        // 生成大根堆
        buildMaxHeap(nums);

        // 逐个取出堆顶元素，放到堆尾，把堆尾元素放到堆顶
        // 然后把堆大小减1 !!!，再调整堆为大根堆
        // 直到堆大小为1终止
        for (int i = nums.length - 1; i > 0; i--) {
            Tool.swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int heapSize = nums.length;
        // i初始值为什么是heapSize / 2，不是应该是heapSize / 2 - 1吗
        // 如果heapSize小于2，i为0，i-1为负数，不方便下边处理
        // 所以从heapSize/2开始处理，i最小值也会是0，方便下面处理
        // 而正常情况下，heapSize / 2没有子节点，不会影响下方处理
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    /**
     * 对以i为根的子树构建大根堆
     */
    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            Tool.swap(nums, i, largest);
            // 为什么这么操作
            // 底层树调整后，不需要这么做，但是顶层树调整后，可能有很小的值从根节点调整到子节点，成为新的子树的根节点，需要继续调整子树
            maxHeapify(nums, largest, heapSize);
        }
    }

}

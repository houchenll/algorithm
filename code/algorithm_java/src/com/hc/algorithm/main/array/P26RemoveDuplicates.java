package com.hc.algorithm.main.array;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 26. 删除有序数组中的重复项
 * tag_easy, tag_array
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class P26RemoveDuplicates {

    public static void main(String[] args) {
        P26RemoveDuplicates p26 = new P26RemoveDuplicates();

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = p26.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        return finalSolution(nums);
    }

    /**
     * 方法1：标记法
     * 第一个标记i，记录数组当前遍历到的位置，从1向右遍历整个数组
     * 第二个标记j，记录数组无重复数字部分的最后一个数字的坐标，当有新数字时，j加1
     * 过程：初始时i为1，j为0，i向右遍历整个数组，对每个遍历到的数字nums[i]，检查它与j位置的元素是否相同
     * 如果相同，j不动，如果不同，j加1，并把nums[j]赋值为nums[i]
     * 0 ms, > 100%
     * 39.8MB, > 47.58%
     */
    private int solution1(int[] nums) {
        int j = 0;
        int len = nums.length;  // 避免每次循环时计算数组长度，可以加快速度
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    /**
     * 方法2：双指针法
     * 与方法1的区别：
     * 1. 添加了对数组长度的判断，长度为0时直接返回
     * 2. 结合了有序数组的特点，num[i]只和前一个元素比较，而不是和j位置比较(不会影响性能)
     * 3. j初始化等于下一个元素位置（这个不重要）
     * 4. 使用fast, slow作为变量名，更易读
     * 1ms, > 99.6%
     * 39.9MB, > 17.36%
     */
    private int solution2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    /**
     * 方法3：双指针法（最终方案）
     * 1. 检查数组长度是否为0
     * 2. 提取数组长度，避免循环时计算数组长度
     * 3. slow从0开始，nums[fast]和nums[slow]比较是否相等，不等时slow加1并赋值为nums[fast]，避免每次比较时计算fast-1
     * 4. 使用fast, slow作为指针名，可读性更高
     * 1ms, > 99.6%
     * 40MB, > 13.59%
     */
    private int finalSolution(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < len; fast++) {
            if (nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
        }

        return slow + 1;
    }

}

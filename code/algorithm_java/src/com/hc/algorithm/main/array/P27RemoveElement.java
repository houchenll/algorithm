package com.hc.algorithm.main.array;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 27. 移除元素
 * tag_easy, tag_array
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class P27RemoveElement {

    public static void main(String[] args) {
        P27RemoveElement p27 = new P27RemoveElement();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int result = p27.removeElement(nums, val);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public int removeElement(int[] nums, int val) {
        return solution2(nums, val);
    }

    /**
     * 方法1：双指针 同向 快慢不同移动
     * fast用于遍历原数组
     * slow表示删除val元素后数组元素的位置
     * slow初始为0
     * fast从0向右遍历数组，如果nums[fast]==val，跳过；如果不等，nums[slow]赋值为nums[fast]，slow加1
     * 0ms > 100%
     * 36.9MB > 73.56%
     */
    private int solution1(int[] nums, int val) {
        int len = nums.length;
        // fast从0开始，可以不用检查数组长度
//        if (len == 0) return 0;

        int slow = 0;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /**
     * 方法2：双指针向中间收拢
     * 方法1的缺点是对类似[1,2,3,4,5]要去除1这样的数组，2.3.4.5都要移动一次，为避免这种问题可以把5移动覆盖到1的位置
     * 实现方面，我们依然使用双指针，两个指针初始时分别位于数组的首尾，向中间移动遍历该序列。
     * 如果左指针 left 指向的元素等于 val，此时将右指针 right 指向的元素复制到左指针 left 的位置，然后右指针 right 左移一位。
     * 如果赋值过来的元素恰好也等于 val，可以继续把右指针 right 指向的元素的值赋值过来（左指针 left 指向的等于 val 的元素的位置继续被覆盖），
     * 直到左指针指向的元素的值不等于 val 为止。
     * 当左指针 left 和右指针 right 重合的时候，左右指针遍历完数组中所有的元素。
     * 0ms > 100%
     * 36.9MB > 71.17%
     * */
    private int solution2(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}

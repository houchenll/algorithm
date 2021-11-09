package com.hc.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class P15ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**
     * 方法1：排序 + 双指针
     * 思路：基于三重循环进行优化
     * 1. 使用三重循环遍历所有符合条件三元组，再用hashMap去重
     * 2. 优化1：先对数组排序，避免去重操作。但仍是三重循环
     * 3. 优化2：如果我们固定了前两重循环枚举到的元素 a 和 b，那么只有唯一的 c 满足 a+b+c=0。
     * 当第二重循环往后枚举一个元素 b'时，由于 b' > b，那么满足 a+b'+c'=0 的 c'一定有 c' < c，
     * 即 c'在数组中一定出现在 c 的左侧。也就是说，我们可以从小到大枚举 b，同时从大到小枚举 c，
     * 即第二重循环和第三重循环实际上是并列的关系。有了这样的发现，我们就可以保持第二重循环不变，
     * 而将第三重循环变成一个从数组最右端开始向左移动的指针，直到 a+b+c 不大于 0
     * 经验：当我们需要枚举数组中的两个元素时，如果我们发现随着第一个元素的递增，第二个元素是递减的，
     * 那么就可以使用双指针的方法，将枚举的时间复杂度从 O(N^2) 减少至 O(N)。为什么是 O(N) 呢？
     * 这是因为在枚举的过程每一步中，「左指针」会向右移动一个位置（也就是题目中的 b），而「右指针」会向左移动若干个位置，
     * 这个与数组的元素有关，但我们知道它一共会移动的位置数为 O(N)，均摊下来，每次也向左移动一个位置，
     * 因此时间复杂度为 O(N)。
     * 复杂度：注意到我们的伪代码中还有第一重循环，时间复杂度为 O(N)O(N)，因此枚举的总时间复杂度为 O(N^2)。
     * 由于排序的时间复杂度为 O(NlogN)，在渐进意义下小于前者，因此算法的总时间复杂度为 O(N^2)。
     * 时间复杂度：O(N^2)，其中 N 是数组 nums 的长度
     * 空间复杂度：O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为 O(logN)。
     * 然而我们修改了输入的数组 nums，在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了 nums 的副本并进行排序，
     * 空间复杂度为 O(N)。
     * 21ms > 66.98%
     */
    private List<List<Integer>> solution1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        // 枚举a
        for (int first = 0; first < n; first++) {
            // 需要和上次枚举的数不同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举b，从first+1到third
            for (int second = first + 1; second < n; second++) {
                // 需要和上次枚举的数字不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证b的指针在c指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着b后续的增加，就不会有满足a+b+c=0并且b<c的c了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

}

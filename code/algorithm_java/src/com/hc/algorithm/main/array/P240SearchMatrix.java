package com.hc.algorithm.main.array;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class P240SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return false;
    }

    /**
     * 方法1：二分查找
     * 因为每行是有序的，所以对每行进行二分查找
     * 时间复杂度：O(M logN)
     * 空间复杂度：O(1)
     */
    private boolean binarySearchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        for (int[] arr : matrix) {
            int i = binarySearch(arr, target);
            if (i >= 0) {
                return true;
            }
        }

        return false;
    }

    private int binarySearch(int[] array, int target) {
        if (null == array || array.length == 0) {
            return -1;
        }

        int l = 0, r = array.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    /**
     * Z形查找
     */
    private boolean zSearch(int[][] matrix, int target) {
        if (null == matrix || null == matrix[0] || 0 == matrix[0].length) {
            return false;
        }

        int row = matrix.length, column = matrix[0].length;
        int r = 0, c = column - 1;
        while (r < row && c >= 0) {
            // 在以(row-1, 0)以左下角，以(r,c)为右上角的矩形中查找
            // 只能向左、向下查找，向左是减小，向下是增大
            if (matrix[r][c] == target) {
                return true;
            }
            if (matrix[r][c] > target) {
                // c列递增，没有等于target项，所以只能从左侧列中继续查找
                c--;
            } else {
                // 向下增大寻找target
                r++;
            }
        }

        return false;
    }

}

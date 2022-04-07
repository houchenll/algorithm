package com.hc.algorithm.main.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class P54SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        return null;
    }

    /**
     * 顺时针旋转
     * 0ms > 100%
     * 时间复杂度：O(MN)
     * 空间复杂度：O(MN)
     */
    private List<Integer> solution1(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        // 定义4个顺序，分别表示行和列的变化值，当遇到边界或访问到已访问过的元素时，变向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = matrix.length;
        int columns = matrix[0].length;
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];

        // 初始化
        int curDirection = 0;
        int index = 0, row = 0, column = 0;

        while (index++ < total) {
            // 先取出当前元素，添加到数组中
            ans.add(matrix[row][column]);
            // 把当前元素对应位置标记为已访问过
            visited[row][column] = true;
            // 试探能否按当前方向是否可以继续前进，即试探是否需要换向，如果需要换向，换向
            // 计算继续按当前方向行进后的row和column
            int nextRow = row + directions[curDirection][0];
            int nextColumn = column + directions[curDirection][1];
            // 如果越界或进入到已访问过的元素，换向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                curDirection = (curDirection + 1) % 4;
            }
            // 计算下次访问的行列
            row += directions[curDirection][0];
            column += directions[curDirection][1];
        }

        return ans;
    }

}

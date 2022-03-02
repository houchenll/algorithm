package com.hc.algorithm.main.graph;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class P200IslandNumber {

    public int numIslands(char[][] grid) {
        return 0;
    }

    /**
     * 方法1：深度优先搜索
     * 把二维数组看成无向图，逐个遍历所有元素
     * 如果元素为1，陆地数加1，并从这个元素开始深度优先遍历，把所有相邻的陆地元素都置为0
     * 深度优先遍历的次数就是陆地的数量
     * 2ms > 99.89%
     * 时间复杂度：O(MN)，每个节点都遍历了一次
     * 空间复杂度：O(MN)，如果整个二维数组都是陆地，那么递归调用MN次
     * 也可用广度优先搜索代替深度优先搜索
     */
    private int solution1(char[][] grid) {
        if (null == grid || 0 == grid.length || 0 == grid[0].length) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandNum = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if ('1' == grid[i][j]) {
                    islandNum++;
                    dfs(grid, i, j, nr, nc);
                }
            }
        }

        return islandNum;
    }

    /**
     * 深度优先遍历，把所有相邻的陆地全部置为0
     */
    private void dfs(char[][] grid, int r, int c, int nr, int nc) {
        // 出界或遇到水元素时停止
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        // 当前节点是陆地，先把当前节点置为0，再分别遍历它的上下左右节点
        grid[r][c] = '0';
        dfs(grid, r, c - 1, nr, nc);
        dfs(grid, r, c + 1, nr, nc);
        dfs(grid, r - 1, c, nr, nc);
        dfs(grid, r + 1, c, nr, nc);
    }

}

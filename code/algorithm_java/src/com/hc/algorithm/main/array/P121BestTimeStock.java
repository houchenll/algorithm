package com.hc.algorithm.main.array;

/**
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices ，它的第i个元素prices[i]表示一支给定股票第i天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class P121BestTimeStock {

    /**
     * 买卖股票，期望是在最低点买入，在最高点卖出
     * 另外，卖出总是在买入之后，换句话说，最大卖出价出现在低点之后
     * 所以遍历一遍数组，找到当前最小值
     * 同时，对当前最小值之后的每个数字，考虑它与当前最小值的差值，如果大于当前最大利润，替换
     * 注意：最大利润不一定是由全局最低价产生的
     * 1ms > 100%
     * 时间复杂度：O(N)，只需遍历一次
     * 空间复杂度：O(1)，只需常数个变量
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                maxProfit = Math.max(price - min, maxProfit);
            }
        }
        return maxProfit;
    }

}

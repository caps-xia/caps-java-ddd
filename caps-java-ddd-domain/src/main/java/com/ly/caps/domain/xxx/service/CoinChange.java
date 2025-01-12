package com.ly.caps.domain.xxx.service;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        if (result != -1) {
            System.out.println("Minimum coins required: " + result);
        } else {
            System.out.println("Amount cannot be formed with given coins.");
        }
    }

    // 使用动态规划的方法优化
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        // 动态规划数组，dp[i]表示凑成金额i所需的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 初始化为一个大于可能的最大值的数字
        dp[0] = 0; // 凑成金额0所需的硬币数为0

        // 遍历所有可能的金额
        for (int i = 1; i <= amount; i++) {
            // 对于每种硬币面值
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果dp[amount]没有被更新，则说明无法凑成该金额
        return dp[amount] > amount ? -1 : dp[amount];
    }

    // 使用记忆化搜索的方法优化
    private static int[] memo;

    public static int coinChangeRecursive(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        memo = new int[amount + 1];
        Arrays.fill(memo, -2); // -2 表示尚未计算
        int result = helper(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount - coin);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, res + 1);
            }
        }

        memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amount];
    }
}

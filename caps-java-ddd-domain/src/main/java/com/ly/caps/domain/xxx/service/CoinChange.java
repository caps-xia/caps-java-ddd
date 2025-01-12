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

    public static int coinChange(int[] coins, int amount) {
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
}

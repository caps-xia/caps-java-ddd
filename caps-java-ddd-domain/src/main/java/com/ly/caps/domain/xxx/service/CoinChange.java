package com.ly.caps.domain.xxx.service;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = coinChange(coins, amount);
        System.out.println(result == -1 ? "Amount cannot be formed with given coins." : "Minimum coins required: " + result);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a value greater than the maximum possible
        dp[0] = 0; // Base case

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

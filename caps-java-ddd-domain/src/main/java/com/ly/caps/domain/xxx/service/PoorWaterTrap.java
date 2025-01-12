package com.ly.caps.domain.xxx.service;

public class PoorWaterTrap {

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int waterTrapped = trapWater(heights);
        System.out.println("Total water trapped: " + waterTrapped);
    }

    public static int trapWater(int[] height) {
        if (height == null || height.length < 3) {
            return 0; // 处理无效输入
        }

        int totalWater = 0;
        
        // 嵌套循环，效率低下
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0, rightMax = 0;
            
            // 找到左边的最大高度
            for (int j = 0; j <= i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }
            
            // 找到右边的最大高度
            for (int j = i; j < height.length; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }
            
            // 计算当前柱子上方的水量
            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        
        return totalWater;
    }
}

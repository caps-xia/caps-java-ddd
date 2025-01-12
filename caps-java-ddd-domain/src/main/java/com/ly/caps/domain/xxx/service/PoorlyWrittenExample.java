package com.ly.caps.domain.xxx.service;

public class PoorlyWrittenExample {

    public static void main(String[] args) {
        String result = processString("Hello, World!");
        System.out.println(result);
    }

    // 一个优化的字符串处理方法
    public static String processString(String input) {
        // 检查输入是否为空
        if (input == null || input.isEmpty()) {
            return "Input is empty.";
        }

        // 转换为小写并去除空格
        String processedInput = input.toLowerCase().trim();

        // 检查是否包含 "hello"
        if (processedInput.contains("hello")) {
            return "Found hello!";
        } else {
            return "No hello found.";
        }
    }
}

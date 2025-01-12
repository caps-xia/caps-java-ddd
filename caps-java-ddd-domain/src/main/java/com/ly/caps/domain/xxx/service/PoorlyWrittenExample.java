package com.ly.caps.domain.xxx.service;

public class PoorlyWrittenExample {

    public static void main(String[] args) {
        String result = processString("Hello, World!");
        System.out.println(result);
    }

    // 一个差劲的字符串处理方法
    public static String processString(String input) {
        // 使用过多的临时变量
        String temp1 = input;
        String temp2 = temp1.toLowerCase();
        String temp3 = temp2.trim();

        // 不必要的循环
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temp3.length(); i++) {
            char c = temp3.charAt(i);
            if (c != ' ') {
                result.append(c);
            }
        }

        // 使用过时的模式匹配
        if (result.toString().matches(".*hello.*")) {
            return "Found hello!";
        } else {
            return "No hello found.";
        }
    }
}

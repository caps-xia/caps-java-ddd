package com.ly.caps.domain.xxx.service;

public class PoorBubbleSort {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 6, 2};
        bubbleSort(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // 处理空数组或单元素数组
        }

        // 外层循环次数过多
        for (int i = 0; i < array.length; i++) {
            // 不必要的内层循环
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换元素
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

package com.george.sort;

import java.util.Arrays;

/**
 * <p>
 *     快速排序-双边循环
 * </p>
 *
 * @author George
 * @date 2023.08.20 11:09
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,9,8,7,6,5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快排
     * @param arr 需要排序的数组
     * @param start 第一个元素下标
     * @param end 最后一个元素的下标
     */
    private static void quickSort(int[] arr, int start, int end) {
        // 递归结束的条件
        if (start >= end) {
            return;
        }
        // 获取基准元素的位置
        int pivod = pivot(arr, start, end);
        // 排序基准元素前的数组元素
        quickSort(arr, start, pivod - 1);
        // 排序基准元素后的数组元素
        quickSort(arr, pivod + 1, end);
    }

    /**
     * 获取基准元素的位置
     * @param arr 数组
     * @param start 开始元素下标
     * @param end 结束元素下标
     * @return
     */
    private static int pivot(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left != right) {
            // 右指针左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 左指针右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 左右交换
            if (left < right) {
                int t = arr[right];
                arr[right] = arr[left];
                arr[left] = t;
            }
        }

        // 交换pivot和重合点
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }
}

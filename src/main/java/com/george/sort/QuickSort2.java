package com.george.sort;

import java.util.Arrays;

/**
 * <p>
 *     快速排序2-单边循环法
 * </p>
 *
 * @author George
 * @date 2023.08.20 14:29
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr={4,7,3,5,6,2,8,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序-单边循环
     * @param arr 数组
     * @param start 数组开始元素下标
     * @param end 结束元素下标
     */
    private static void quickSort(int[] arr, int start, int end) {
        // 递归结束的标记
        if (start >= end) {
            return;
        }
        // 获取基准元素位置
        int pivot = pivot(arr, start, end);
        // 前半段
        quickSort(arr, start, pivot - 1);
        // 后半段
        quickSort(arr, pivot + 1, end);
    }

    /**
     * 获取基准元素位置
     * @param arr 数组
     * @param start 数组开始下标
     * @param end 结束下标
     * @return
     */
    private static int pivot(int[] arr, int start, int end) {
        int pivot = arr[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                mark++;
                int t = arr[mark];
                arr[mark] = arr[i];
                arr[i] = t;
            }
        }
        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}

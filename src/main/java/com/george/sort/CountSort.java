package com.george.sort;

import java.util.Arrays;

/**
 * <p>
 *     计数排序
 * 计数排序：适合于连续的取值范围不大的数组
 * 不连续和取值范围过大会造成数组过大
 * </p>
 *
 * @author George
 * @date 2023.08.21 17:02
 */
public class CountSort {
    public static void main(String[] args) {
        int[] scores = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};

        int[] arr = countSort(scores, 90);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 计数排序
     * @param scores 原数组
     * @param offset 偏移量
     * @return
     */
    private static int[] countSort(int[] scores, int offset) {
        // 声明一个空数组，长度与原数组相同
        int[] nums = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            // 获取在 nums数组中的下标
            int num = scores[i] - offset;
            // 下标元素自增
            nums[num]++;
        }

        // 声明数组，存放排序后的元素
        int[] nums2 = new int[scores.length];
        // i是计数数组的下标，k是新数组的下标
        for (int i = 0, k = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                // 先执行 nums2[k], 再执行: k++
                nums2[k++] = i + offset;
            }
        }
        return nums2;
    }
}

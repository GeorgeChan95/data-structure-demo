package com.george.sort;

import java.util.Arrays;

/**
 * <p>
 *     堆排序
 * </p>
 *
 * @author George
 * @date 2023.08.17 12:47
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr={7,6,4,3,5,2,10,9,8};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        // 排序后的数组
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 数组排序
     * @param arr
     */
    private static void sortArray(int[] arr) {
        // 1、将无序数组构建成大顶堆
        for (int i = arr.length/2-1; i >= 0; i--) { // arr.length/2-1 获取到第一个非叶子节点的元素下标
            adjustHeap(arr, i, arr.length);
        }
        // 2、调整堆结构，堆顶与末尾元素交换，产生了一个新的堆，再调整
        // 堆顶(最大元素)：arr[0], 最后一个元素：arr[arr.length - 1]
        for (int i = arr.length - 1; i > 0; i--) {
            // 最后和最大交换
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            // 调整大顶堆
            // 首次执行，末尾的最大值，后面每次执行都长度再次减1，跳过左右排序好的大的元素。
            adjustHeap(arr, 0, i);
        }
    }

    /**
     *
     * @param arr 数组
     * @param parent 父节点下标
     * @param len 数组长度
     */
    private static void adjustHeap(int[] arr, int parent, int len) {
        // 临时变量保存父节点的值
        int tmp = arr[parent];
        // 左子元素的下标
        int child = 2 * parent + 1;
        while (child < len) {
            // 判断是否有右子节点，右子节点是否大于左子节点
            if (child + 1 < len && arr[child + 1] > arr[child]) {
                // 右子节点的下标值
                child++;
            }
            // 如果父元素大于子元素则不用交换
            if (tmp >= arr[child]) break;
            // 把子元素的值赋值给父元素
            arr[parent] = arr[child];
            // 子元素的下标位置给父元素,(相当于父子交换,tmp移动到当前子元素的位置，成为下一轮循环的父元素)
            parent = child;
            // 找到下一轮循环的左子节点
            child = 2 * child + 1;
        }
        // 将父元素的值给子节点（将最开的是父节点的值，给最后一轮交换后的子元素）
        arr[parent] = tmp;
    }
}

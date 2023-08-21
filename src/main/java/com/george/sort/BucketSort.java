package com.george.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * <p>
 *     桶排序
 * </p>
 *
 * @author George
 * @date 2023.08.21 17:26
 */
public class BucketSort {
    public static void main(String[] args) {
        double[] array = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sortedArray = bucketSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    /**
     * 桶排序
     * @param array
     * @return
     */
    private static double[] bucketSort(double[] array) {
        // 1、获取数组最大值和最小值之间的差值
        double max = 0;
        double min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min; // 差值

        // 桶初始化
        int bucketNum = array.length;// 桶的数量
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        // 循环，将每个元素放在对应的桶中
        for (int i = 0; i < array.length; i++) {
            // 计算元素放置的桶的下标
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        // 遍历桶，将桶内的元素排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        double[] sortedArr = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (Double item : list) {
                sortedArr[index] = item;
                index++;
            }
        }

        return sortedArr;
    }
}

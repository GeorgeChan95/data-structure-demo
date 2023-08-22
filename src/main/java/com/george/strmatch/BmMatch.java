package com.george.strmatch;

/**
 * <p>
 *     字符串BM匹配算法
 * </p>
 *
 * @author George
 * @date 2023.08.22 11:13
 */
public class BmMatch {
    public static void main(String[] args) {
        String s1="abcabcabcd";
        String s2="cabcd";

        int index = matchIndex(s1.toCharArray(), s2.toCharArray());
        System.out.println(index);
    }


    /**
     * bm算法，获取字符串匹配的索引
     * @param main 主字符串
     * @param pattern 匹配的字符串
     * @return
     */
    private static int matchIndex(char[] main, char[] pattern) {
        int n = main.length;
        int m = pattern.length;
        // 声明一个字典数组
        int[] dc = new int[256];
        // 存入模式串字符到字典中
        genBC(pattern, m, dc);

        int i = 0;
        while (i <= n-m) {
            int j = 0;
            // 从模式串的最后一个字符开始往前，逐一与主串的每个字符进行比较
            for (j = m-1; j >= 0; j--) {
                if (main[i+j] != pattern[j]) break;
            }
            // 匹配成功，模式串中每个字符都在主串中得到连续的匹配
            if (j < 0) {
                return i;
            }
            // 没有找到完全匹配的，计算要后移的字符数
            // si - xi
            i = i + (j - dc[(int)main[i+j]]);
        }
        // 没有找到匹配的
        return -1;
    }

    /**
     * 将模式字符串拆分成字符，存入字段数组中
     * 下标位ASCII码值，值为字符在模式串中最后一次出现的下标值
     * @param pattern 模式串
     * @param m 模式串的长度
     * @param dc 字典数组
     */
    private static void genBC(char[] pattern, int m, int[] dc) {
        // 初始化字典数组
        for (int i = 0; i < 256; i++) {
            dc[i] = -1;
        }

        // 将模式串中的每个字符放入字典数组中
        // 字符的ASCII码值作为字典数组的下标，值为字符在模式串中最后一次出现的下标值
        for (int i = 0; i < m; i++) {
            int asc = (int)pattern[i];
            dc[asc] = i;
        }
    }
}

package com.george.strmatch.trie;

/**
 * <p></p>
 *
 * @author George
 * @date 2023.08.23 19:59
 */
public class TrieMatch {
    TrieNode root = new TrieNode('/');

    public static void main(String[] args) {
        TrieMatch trieMatch = new TrieMatch();
        trieMatch.insert("hello".toCharArray());
        trieMatch.insert("how".toCharArray());
        trieMatch.insert("he".toCharArray());

        boolean res = trieMatch.find("how".toCharArray());
        System.out.println(res);
    }



    /**
     * 插入字符数组到字典树中
     * @param charArr
     */
    private void insert(char[] charArr) {
        TrieNode p = root;
        for (int i = 0; i < charArr.length; i++) {
            // 字符在数组中的下标
            int index = charArr[i] - 'a';
            // 字符是否存在（字符存在，前面的字符必须也存在）
            TrieNode child = p.children[index];
            if (child == null) {
                // 不存在则创建新的子节点
                child = new TrieNode(charArr[i]);
                p.children[index] = child;
            }
            // 将父节点指向子节点
            p = child;
        }
        // 最后一个字符标记为叶子节点
        p.isLeaf = true;
    }

    /**
     * 查找字符串
     * @param charArr
     */
    private boolean find(char[] charArr) {
        TrieNode p = root;
        for (int i = 0; i < charArr.length; i++) {
            int index = charArr[i] - 'a';
            TrieNode child = p.children[index];
            if (child == null) {
                return false;
            }
            p = child;
        }
        if (!p.isLeaf) {
            // 字符串没有完全匹配（字符不是原字符串的最后一个字符）
            return false;
        }
        return true;
    }
}

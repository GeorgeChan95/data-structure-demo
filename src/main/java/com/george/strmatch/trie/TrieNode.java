package com.george.strmatch.trie;

/**
 * <p></p>
 *
 * @author George
 * @date 2023.08.23 19:54
 */
public class TrieNode {
    /**
     * 字符数据
     */
    char data;

    /**
     * 孩子节点
     */
    TrieNode[] children = new TrieNode[26];

    /**
     * 是否是叶子节点
     */
    boolean isLeaf = false;

    public TrieNode(char data) {
        this.data = data;
    }
}

package com.george.binarytree;

/**
 * <p>
 *     树节点
 * </p>
 *
 * @author George
 * @date 2023.07.30 12:29
 */
public class TreeNode {
    /**
     * 节点数据
     */
    private Integer data;
    /**
     * 左子节点
     */
    private TreeNode leftChild;
    /**
     * 右子节点
     */
    private TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

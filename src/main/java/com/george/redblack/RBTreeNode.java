package com.george.redblack;

/**
 * <p></p>
 *
 * @author George
 * @date 2023.08.12 16:38
 */
public class RBTreeNode {
    private int key;

    private String color;

    private RBTreeNode left;

    private RBTreeNode right;

    private RBTreeNode parent;

    public RBTreeNode() {
    }

    public RBTreeNode(Integer key) {
        this.key = key;
        this.color = "red";
    }

    public int getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBTreeNode{" +
                "key=" + key +
                ", color='" + color + '\'';
    }
}

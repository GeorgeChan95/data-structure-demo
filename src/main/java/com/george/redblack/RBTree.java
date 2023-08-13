package com.george.redblack;

import com.sun.org.apache.regexp.internal.RE;

/**
 * <p></p>
 *
 * @author George
 * @date 2023.08.12 16:42
 */
public class RBTree {

    private static final String BLACK = "black";
    private static final String RED = "red";

    private RBTreeNode root;

    public static void main(String[] args) {
        RBTree tree = new RBTree();
        tree.insert(11);
        tree.insert(10);
        tree.insert(12);
        tree.insert(7);
        tree.insert(5);

        tree.list(tree.root);
    }

    /**
     * 遍历节点
     * @param node
     */
    public void list(RBTreeNode node){
        if(node==null) return;
        //递归终止条件
        if(node.getLeft()==null&&node.getRight()==null){
            System.out.println(node);
            return ;
        }
        System.out.println(node);
        list(node.getLeft());
        list(node.getRight());
    }

    /**
     * 插入数据
     * @param key
     */
    private void insert(int key) {
        RBTreeNode node = new RBTreeNode(key);
        // 插入根节点
        if (root == null) {
            node.setColor(BLACK);
            root = node;
            return;
        }

        RBTreeNode parent = root;
        RBTreeNode son = null;

        // 左子节点
        if (key < parent.getKey()) {
            son = parent.getLeft();
        }

        // 右子节点
        if (key > parent.getKey()) {
            son = parent.getRight();
        }

        // 如果key已存在，跳过
        if (key == parent.getKey()) {
            return;
        }

        // 递归查找插入元素的父节点
        while (son != null) {
            parent = son;
            if (key < parent.getKey()) {
                son = parent.getLeft();
            } else if (key > parent.getKey()) {
                son = parent.getRight();
            } else {
                System.out.println("key 已存在");
            }
        }

        // 添加左子节点
        if (key < parent.getKey()) {
            parent.setLeft(node);
        } else if (key > parent.getKey()) { // 添加右子节点
            parent.setRight(node);
        } else {
            System.out.println("key 已存在");
        }
        node.setParent(parent);

        // 自平衡
        balanceInsert(node);
    }

    /**
     * 插入自平衡
     * @param node 当前插入的节点
     */
    private void balanceInsert(RBTreeNode node) {
        RBTreeNode father = node.getParent();
        RBTreeNode gFather = null;

        // 仅当父节点不为空，且父节点是红色，才需要自平衡
        while (father != null && father.getColor().equals(RED)) {
            gFather = father.getParent();
            // 父节点在祖父节点的左边
            if (gFather.getLeft() == father) {
                // 获取叔叔节点
                RBTreeNode uncle = gFather.getRight();
                if (uncle != null && uncle.getColor().equals(RED)) { // 叔叔节点不可能是黑色
                    // 颜色反转
                    uncle.setColor(BLACK);
                    father.setColor(BLACK);
                    gFather.setColor(RED);
                    node = gFather;
                    continue;
                }
                // 如果当前节点是父节点的右子节点，则需要先左旋，再右旋
                // 如果当前节点是父节点的左子节点，则只需要右旋
                if (node == father.getRight()) {
                    // 左旋
                    leftRotate(father);
                    // 交换
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                // 变色
                setBlack(father);
                setRed(gFather);
                // 右旋
                rightRotate(gFather);
            } else {// 父节点在祖父节点的右边
                // 获取叔叔节点
                RBTreeNode uncle = gFather.getLeft();
                if (uncle != null && uncle.getColor().equals(RED)) { // 叔叔节点不可能是黑色,否则违背了：任一节点到自身的子节点所经过的黑色节点的数量相同 的规定
                    // 颜色反转
                    setBlack(uncle);
                    setBlack(father);
                    setRed(gFather);
                    node = gFather;
                    continue;
                }
                // 如果当前节点是父节点的左子节点，则需要先右旋，再左旋
                // 如果当前节点是父节点的右子节点，则只需要左旋
                if (node == father.getLeft()) {
                    // 右旋
                    rightRotate(father);
                    // 交换
                    // 交换
                    RBTreeNode tmp = node;
                    node = father;
                    father = tmp;
                }
                // 变色
                setBlack(father);
                setRed(gFather);
                // 左旋
                leftRotate(gFather);
            }
        }
        setBlack(root);
    }

    /**
     * 左旋
     * @param node
     */
    private void leftRotate(RBTreeNode node) {
        RBTreeNode right = node.getRight();
        RBTreeNode parent = node.getParent();
        if (parent == null) { // 插入数据是：5、7、10的情况，node是5
            root = right;
            right.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) { // 当前节点是父节点的左子节点，举例：10、5、7,node是5
                parent.setLeft(right);
            } else { // 当前节点是父节点的右子节点，举例：1、3、5、7、10，node是5
                parent.setRight(right);
            }
            right.setParent(parent);
        }
        node.setParent(right);
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(RBTreeNode node) {
        RBTreeNode left = node.getLeft();
        RBTreeNode parent = node.getParent();
        if (parent == null) { // 举例：10、7、5，node是10
            root = left;
            left.setParent(null);
        } else {
            if (parent != null && parent.getLeft() == node) { // 当前节点是父节点的左子节点，举例：11、10、12、7、5，node是10
                parent.setLeft(left);
            } else { // 当前节点是父节点的右子节点，举例：5、10、7，node是10
                parent.setRight(left);
            }
            left.setParent(parent);
        }
        node.setParent(left);
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    /**
     * 设置节点为黑色
     * @param node
     */
    private void setBlack(RBTreeNode node) {
        node.setColor(BLACK);
    }

    /**
     * 设置节点为红色
     * @param node
     */
    private void setRed(RBTreeNode node) {
        node.setColor(RED);
    }
}

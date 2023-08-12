package com.george.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *     二分树
 *     二分树的插入、遍历、查询
 * </p>
 *
 * @author George
 * @date 2023.07.30 12:28
 */
public class BinarySearch {
    private static TreeNode root;
    public static void main(String[] args) {
        // 二叉树的插入
        BinarySearch bs  = new BinarySearch();
        bs.insertData(8);
        bs.insertData(4);
        bs.insertData(12);
        bs.insertData(2);
        bs.insertData(14);
        bs.insertData(3);
        bs.insertData(10);
        bs.insertData(9);
        bs.insertData(11);
        System.out.println("二叉树插入数据结束");

        // 二叉树的遍历
        // 前序遍历：根、左、右
//        beforeTraver(root);
        // 中序遍历
//        midTraver(root);
        // 后序遍历
        afterTraver(root);

        // 广度优先遍历
        levelOrderTraveral(root);
    }

    /**
     * 广度优先遍历
     * 也叫层序遍历，顾名思义，就是二叉树按照从根节点到叶子节点的层次关系，一层一层横向遍历各个节点。
     * @param root
     */
    private static void levelOrderTraveral(TreeNode root) {
        // 声明队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 头部队列出列
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.getData());
            // 左子节点入队
            if (treeNode.getLeftChild() != null) {
                queue.offer(treeNode.getLeftChild());
            }
            // 右子节点入队
            if (treeNode.getRightChild() != null) {
                queue.offer(treeNode.getRightChild());
            }
        }
    }

    /**
     * 插入数据
     * @param node 当前要操作的数据节点
     */
    private void insertData(int node) {
        root = insert(root, node);
    }

    /**
     * 递归插入数据方法
     *
     * @param treeNode 父节点
     * @param data 当前要操作的数据
     * @return
     */
    private TreeNode insert(TreeNode treeNode, int data) {
        if (treeNode == null) { // 如果传入的节点是空，则将当前数据创建成一个节点，并返回
            return new TreeNode(data);
        } else if (data<treeNode.getData()) {
            // 如果数据小于父节点，则当前数据插入到父节点的左边
            treeNode.setLeftChild(insert(treeNode.getLeftChild(), data));
        } else {
            // 如果数据大于父节点，则插入到父节点的右边
            treeNode.setRightChild(insert(treeNode.getRightChild(), data));
        }
        return treeNode;
    }

    /**
     * 二叉树的前序遍历，输出顺序是根节点、左子树、右子树
     * @param node
     */
    private static void beforeTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");

        beforeTraver(node.getLeftChild());
        beforeTraver(node.getRightChild());
    }

    /**
     * 二叉树的中序遍历，输出顺序是左子树、根节点、右子树
     * 即：数据从小到大遍历
     * @param node
     */
    private static void midTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        midTraver(node.getLeftChild());
        System.out.print(node.getData() + " ");
        midTraver(node.getRightChild());
    }

    /**
     * 二叉树的后序遍历，输出顺序是左子树、右子树、根节点
     * @param node
     */
    private static void afterTraver(TreeNode node) {
        if (node == null) {
            return;
        }
        afterTraver(node.getLeftChild());
        afterTraver(node.getRightChild());
        System.out.print(node.getData() + " ");
    }
}

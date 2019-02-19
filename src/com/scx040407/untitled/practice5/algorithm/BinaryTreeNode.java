package com.scx040407.untitled.practice5.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2018/10/09 下午 9:52
 */
public class BinaryTreeNode {
    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    //后序遍历 递归
    void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    //后序遍历 非递归 使用了2个栈
    void postOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        while (true) {
            while (root!=null) {
                stack.push(root);
                stack2.push(root);
                root = root.getRight();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (BinaryTreeNode) stack.pop();
            root = root.getLeft();
        }
        while (!stack2.isEmpty()) {
            BinaryTreeNode root2 = (BinaryTreeNode) stack2.pop();
            System.out.println(root2.getData());
        }
    }

    //前序遍历 非递归
    void preOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (BinaryTreeNode) stack.pop();
            root = root.getRight();
        }
    }

    //中序遍历 非递归
    void inOrderNonRecursive(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack stack = new Stack();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = (BinaryTreeNode) stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    //层次遍历
    void levelOrder(BinaryTreeNode root) {
        BinaryTreeNode temp;
        Queue queue = new LinkedList();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = (BinaryTreeNode) queue.poll();
            System.out.println(temp.getData());
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();
        node1.setData(1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setData(2);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setData(3);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setData(4);
        node5.setData(5);
        node6.setData(6);
        node7.setData(7);
//        node1.postOrderNonRecursive(node1);
//        node1.preOrderNonRecursive(node1);
//        node1.inOrderNonRecursive(node1);
        node1.levelOrder(node1);
//        node1.postOrder(node1);
    }

}

package com.scx040407.untitled.practice5.algorithm;

import java.util.List;

/**
 * 2018/08/04 下午 9:12
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }
    public ListNode() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    int ListLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    ListNode InsertLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        // 三种情况，结尾插入，开头插入，中间某位置插入 position是1到size+1
        if (headNode == null) { //若链表为空，插入
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. the valid" +
                    " inputs are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) { //在链表开头插入
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            // 在链表中间或表尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position) {
        int size = ListLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. the valid" +
                    " inputs are 1 to " + size);
            return headNode;
        }
        if (position == 1) { //删除头结点
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else { //删除中间或尾结点
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    void DeleteLinkedList(ListNode head) {
        ListNode auxilaryNode, iterator = head;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null; // 垃圾回收器将自动处理
            iterator = auxilaryNode; //在实际应用中，不需要实现该内容
        }
    }

    /**
     * 查找结点
     */
    ListNode FindListNode(ListNode headNode, int position) {
        int size = ListLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to find is invalid. the valid" +
                    " inputs are 1 to " + size);
            return headNode;
        }
        int count = 1;
        ListNode previousNode = headNode;
        while (count < position - 1) {
            previousNode = previousNode.getNext();
            count++;
        }
        return previousNode.getNext();

    }

    //模拟循环链表
    int CircularListLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        ListNode result = listNode1.FindListNode(listNode1, 4);
        System.out.println(result.getData());
        listNode4.setNext(listNode1);
        System.out.println(listNode1.CircularListLength(listNode1));
    }
}

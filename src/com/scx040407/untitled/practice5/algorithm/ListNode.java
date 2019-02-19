package com.scx040407.untitled.practice5.algorithm;

import java.util.List;

/**
 * 2018/08/04 ���� 9:12
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
        // �����������β���룬��ͷ���룬�м�ĳλ�ò��� position��1��size+1
        if (headNode == null) { //������Ϊ�գ�����
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. the valid" +
                    " inputs are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) { //������ͷ����
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            // �������м���β����
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
        if (position == 1) { //ɾ��ͷ���
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else { //ɾ���м��β���
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
            iterator = null; // �������������Զ�����
            iterator = auxilaryNode; //��ʵ��Ӧ���У�����Ҫʵ�ָ�����
        }
    }

    /**
     * ���ҽ��
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

    //ģ��ѭ������
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

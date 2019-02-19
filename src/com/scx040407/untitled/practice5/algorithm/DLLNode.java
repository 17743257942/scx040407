package com.scx040407.untitled.practice5.algorithm;

/**
 * 2018/08/05 下午 3:02
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = getDLLLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("position of nodeToInsert is invalid " +
                    " The valid inputss are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) { //在链表开头插入
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else { // 在链表中间或末尾插入
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    DLLNode DLLDelete(DLLNode headNode, int position) {
        int size = getDLLLength(headNode);
        //如果被删除位置不再链表，报错并返回
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. the valid" +
                    " inputs are 1 to " + size);
            return headNode;
        }
        if (position == 1) { //删除链表的第一个结点
            DLLNode currentNode = headNode.getNext();
            headNode = null;
            currentNode.setPrevious(null);
            return currentNode;
        } else { //删除中间或尾结点
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if (laterNode != null) {
                //如果后续不是null，那么设置其前驱结点
                laterNode.setPrevious(previousNode);
            }
            currentNode = null;
        }
        return headNode;
    }

    private int getDLLLength(DLLNode headNode) {
        int length = 0;
        DLLNode currentNode = headNode;
        while (headNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }


}

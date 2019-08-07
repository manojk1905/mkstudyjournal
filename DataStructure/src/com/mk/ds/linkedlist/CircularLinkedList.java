package com.mk.ds.linkedlist;

public class CircularLinkedList<T> {
    private Node<T> head;
    public Node<T> tail;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(T data) {
        Node<T> node = new Node<T>(data, head);
        if (head == null) {
            // for blank linked list head and tail will
            //point to same node and
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        tail.next = head;
    }

    public void print(Node<T> node) {
        Node<T> head = node;
        while (node.next != head) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print(node.data);
    }

    public void detectLoop(Node<T> node) {
        Node<T> slowPtr = node;
        Node<T> fastPtr = node;
        boolean circularFlag  = false;
        while (null != fastPtr && null != fastPtr.next) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) {
                circularFlag = true;
                break;
            }
        }
        if(circularFlag) {
            System.out.print("Circular");
        } else
             System.out.print("Non Circular");
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> linkedList = new CircularLinkedList();
        for (int i = 1; i <= 3; i++) {
            linkedList.add(i);
        }
        linkedList.detectLoop(linkedList.head);   // 1->2->3->4->5->6->7->8->9->10->NULL
    }
}

package com.mk.test.linkedlist;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) throws IOException {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNode(1);
        linkedList.insertNode(2);
        linkedList.insertNode(3);
        linkedList.insertNode(4);
        linkedList.insertNode(5);
        linkedList.insertNode(6);

        printSinglyLinkedList(linkedList.head);

        System.out.println("Reversed");
        Node rllist = reverse(linkedList.head);
        printSinglyLinkedList(rllist);
        printMiddleNode(rllist);

        Node rrllist = reverseInLoop(rllist);
        printSinglyLinkedList(rrllist);


    }
    public static void printMiddleNode(Node node) throws IOException {
        Node slowPointer = node;
        Node fastPointer = node;
        while (node != null && fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("Middle element : "+slowPointer.nodeData );
    }

    public static void printSinglyLinkedList(Node node) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.nodeData) + " ");
            node = node.next;
        }
    }
    static Node reverse(Node head) {
        if(head == null) {
            return head;
        }

        if(head.next == null) {
            return head;
        }

        Node newHeadNode = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHeadNode;
    }

    static Node reverseInLoop(Node head) {
        if(head == null) {
            return head;
        }

        if(head.next == null) {
            return head;
        }
        Node prev = null;
        Node next = null;
        Node current = head;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    static class Node {
        int nodeData;
        Node next;

        public Node(int nodeData){
            this.nodeData = nodeData;
            this.next = null;
        }
    }

    static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }
        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head != null) {
                node.next = head;
            }
            this.head = node;
        }

    }
}

package com.mk.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addLast(T data) {
        if (head == null) {
            head = new Node<T>(data, head);
        } else {
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<T>(data, null);
        }
    }

    public void print(Node<T> node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.addLast(7);
        linkedList.print(linkedList.head);   // 1->2->3->4->5->6->7->8->9->10->NULL
        //linkedList.removeDuplicate(linkedList.head);
        Node node = linkedList.rotateByNthNode(linkedList.head, 4);
        linkedList.print(node);
    }

    public void removeDuplicate(Node<Integer> node) {
        Node unique = null;
        Map<Integer, Integer> mapData = new HashMap<>();
        while (null != node) {
            if (null != mapData.get(node.data)) {
                mapData.put(node.data, mapData.get(node.data) + 1);
            } else {
                mapData.put(node.data, 1);
            }
            node = node.next;
        }
        LinkedList<Integer> linkedList = new LinkedList();
        Set<Integer> key = mapData.keySet();
        for (int val : key) {
            linkedList.addLast(val);
        }
        linkedList.print(linkedList.head);
    }

    public void nTheNodeFromEnd(Node currentNode, int n) {

        Node slowPtr = currentNode;
        Node fastPtr = currentNode;
        int count = 1;
        if (null != currentNode) {
            while (null != fastPtr && null != fastPtr.next) {
                fastPtr = fastPtr.next.next;
                if (count > n)
                    slowPtr = slowPtr.next;
            }
            System.out.println("nth element from end is ::" + slowPtr.data);
        }
    }

    public Node rotateByNthNode(Node currentNode, int n) {
        if (n == 0)
            return currentNode;
        Node current = currentNode;
        int count = 1;
        while (count < n && null != current) {
            current = current.next;
            count++;
        }
        Node nThNode = current;
        while (null != current && null != current.next)
            current = current.next;
        current.next = currentNode;
        currentNode = nThNode.next;
        nThNode.next = null;
        return currentNode;
    }
}

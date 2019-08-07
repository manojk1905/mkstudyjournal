package com.mk.ds.linkedlist;

public class ReverseLinkedList<T> {
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

    public Node reverseInGivenSize(Node<T> currentNode) {
        Node<T> finalReverseNode = null;
        Node<T> reverseNode = null;
        Node<T> nextNode = null;
        int count = 0;
        while(currentNode != null) {
            count = count+1;
            nextNode = currentNode.next;
            currentNode.next = reverseNode;
            reverseNode = currentNode;
            currentNode = nextNode;
            if(count == 2  || currentNode == null) {
                if(finalReverseNode == null) {
                    finalReverseNode = reverseNode;
                } else {
                    Node<T> tmp = finalReverseNode;
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = reverseNode;
                }
                reverseNode= null;
                count = 0;
            }
        }
        return finalReverseNode;
    }

    public static void main(String[] args) {
        ReverseLinkedList<Integer> linkedList = new ReverseLinkedList();
        for (int i = 1; i <= 3; i++) {
            linkedList.addLast(i);
        }
        linkedList.print(linkedList.head);   // 1->2->3->4->5->6->7->8->9->10->NULL
        Node reverseNode1 = linkedList.reverseInGivenSize(linkedList.head);
        linkedList.print(reverseNode1);     //2->1->4->3->6->5->8->7->10->9->NULL
    }
}

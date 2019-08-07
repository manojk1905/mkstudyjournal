package com.mk.ds.stack;

public class StackUsingLinkedList {
    private Node top;

    private static class Node {
        char data;    // integer data
        Node next;    // pointer to the next node
    }

    public StackUsingLinkedList() {
        this.top = null;
    }

    public void push(char value) {
        Node node = new Node();
        if (node == null) {
            throw new RuntimeException("Overflow");
        }
        node.data = value;
        node.next = top;
        top = node;
    }

    public boolean isEmpty(){
        if(top == null) {
            return true;
        }
        return false;
    }

    public char pop() {
        if (top == null) {
            throw new RuntimeException("underflow");
        }
        char data = top.data;
        top = top.next;
        return data;
    }
}

class StackImpl {
    public static void main(String[] args) {
        StackImpl stackImpl = new StackImpl();
        char[] balArr = {'{','[',']','}'};
        char[] unBalArr = {'{','[','}'};
        System.out.println("Balanced expression : "+stackImpl.checkBalanced(balArr));
        System.out.println("Balanced expression : "+stackImpl.checkBalanced(unBalArr));
    }

    public boolean checkBalanced(char[] array){
        StackUsingLinkedList stack = new StackUsingLinkedList();
        for(int count = 0; count < array.length; count++) {
            if(array[count] == '(' || array[count] == '{' || array[count] == '[' ) {
                stack.push(array[count]);
            }
            else if (array[count] == ')' || array[count] == '}' || array[count] == ']' ) {
                if(stack.isEmpty())
                    return false;

                char top = stack.pop();
                if(top == '(' && array[count] != ')'
                    || top == '{' && array[count] != '}'
                    || top == '[' && array[count] != ']' ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


package com.mk.ds.stack;

public class Stack {
    private int size;
    private int top;
    private int[] stackArr;

    public Stack(int size){
        stackArr = new int[size];
        this.size = size;
        top = -1;
    }

    public void push(int value){
        if(size == top) {
            throw new RuntimeException("stack is full");
        }
        stackArr[++top] = value;
    }

    public int pop(){
        if(top < 0) {
            throw new RuntimeException("stack is empty");
        }
        int topValue = stackArr[top--];
        return topValue;
    }

    public boolean isEmpty(){
        if(top < 0) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args){
        Stack stack = new Stack(10);
        for(int val = 11 ; val < 21 ; val++) {
            stack.push(val);
        } // insertion order 11 12 13 14 15 16 17 18 19 20
        Stack reversedStack = stack.reverse(stack, -1);
        while (!reversedStack.isEmpty()) {
            System.out.print(reversedStack.pop());
        } // pop from top first
          // 20 19 18 17 16 15 14 13 12 11
    }

    public Stack reverse(Stack stack, int data){
      return null;
    }
}

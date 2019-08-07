package com.mk.ds.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    static Queue<Integer> queue;

    static void Print() {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + ", ");
            queue.remove();
        }
    }

    static void reverseQueue() {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.peek());
            queue.remove();
        }
        while (!stack.isEmpty()) {
            queue.add(stack.peek());
            stack.pop();
        }
    }

    public static void main(String args[]) {
        queue = new LinkedList<Integer>();
        for(int i =10 ; i < 100 ; i = i+10) {
            queue.add(i);
        }   // insert in seq 10, 20, 30, 40, 50, 60, 70, 80, 90
        reverseQueue();
        Print(); // reverse the inserted order
        // 90, 80, 70, 60, 50, 40, 30, 20, 10
    }
}

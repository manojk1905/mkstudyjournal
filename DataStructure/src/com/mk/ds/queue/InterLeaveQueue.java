package com.mk.ds.queue;

import java.util.*;
import java.util.Queue;

class InterLeaveQueue {

    public static void interLeaveQueue(Queue<Integer> q) {
        if (q.size() % 2 != 0)
            System.out.println("Input even number of integers.");

        Stack<Integer> s = new Stack<>();
        int halfSize = q.size() / 2;

        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }

        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
        }

        for (int i = 0; i < halfSize; i++) {
            q.add(q.peek());
            q.poll();
        }

        for (int i = 0; i < halfSize; i++) {
            s.push(q.peek());
            q.poll();
        }

        while (!s.empty()) {
            q.add(s.peek());
            s.pop();
            q.add(q.peek());
            q.poll();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =10 ; i < 20 ; i++) {
            q.add(i);
        }
        interLeaveQueue(q);
        int length = q.size();
        for (int i = 0; i < length; i++) {
            System.out.print(q.peek() + " ");
            q.poll();
        }
    }
}

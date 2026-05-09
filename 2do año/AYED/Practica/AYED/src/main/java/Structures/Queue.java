package Structures;

import java.util.LinkedList;
import java.util.List;

public class Queue <T>{
    private List<T> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(T element) {
        queue.add(element);
    }

    public T dequeue() {
        return queue.removeLast();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

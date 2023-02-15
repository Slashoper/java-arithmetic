package org.example.queue;

public class Queue {
    private int[] data;
    private int front;
    private int rear;
    private int maxsize;


    public Queue(int maxsize){
        this.maxsize = maxsize;
        data = new int[maxsize];
        front = -1;
        rear = -1;
    }

    public void enQueue(int data){
        if(isFull())
            throw new RuntimeException("the queue is full ,cannot enqueue");
        rear = (rear+1) % this.maxsize;
        this.data[rear] = data;
    }

    public int deQueue(){
        if(isEmpty())
            throw  new RuntimeException("the queue is empty!");
        front ++;
        return data[front];
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public boolean isFull(){
        return front == (this.rear+1)% this.maxsize;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
    }
}

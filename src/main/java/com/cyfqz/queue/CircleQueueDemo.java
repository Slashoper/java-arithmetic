package com.cyfqz.queue;

import java.util.Random;
import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {
        Random random = new Random();
        CircleQueue circleQueue =  new CircleQueueDemo.CircleQueue();
        System.out.print("入队元素为");
        for(int i = 0 ;i<19;i++){
            int e = random.nextInt(100000);
            System.out.printf("%d\t",e);
            circleQueue.enQueue(e);
        }

        System.out.print("\n出队元素为");
        while (!circleQueue.isEmpty()){
            System.out.printf("%d\t",circleQueue.deQueue());
        }
    }

    static class CircleQueue{
        private int[] queueArray;
        private static final int maxSize = 20;
        private int front;
        private int rear;

        public CircleQueue() {
            this.queueArray = new int[maxSize];
            front = 0;
            rear = 0;
        }

        public boolean isFull(){
            return (rear+1) % maxSize == 0;
        }

        public boolean isEmpty(){
            return front == rear;
        }

        public void enQueue(int e){
            if (isFull())
                throw  new RuntimeException("该队列满了");
            queueArray[rear] = e;
            rear = (rear+1)%maxSize;
        }

        public int deQueue(){
            if(isEmpty())
                throw new RuntimeException("该队列空的");
            int e = queueArray[front];
            front = (front+1)%maxSize;
            return e;
        }
    }
}



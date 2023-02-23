package com.cyfqz.stack;

import java.util.Random;

/**
 *
 * 基于数组实现栈,index反应,index指向第一个节点 , 栈很简单
 */
public class Stack {
    int[] data;
    int index;

    int capacity;
    public Stack(int capacity){
        this.capacity = capacity;
        data = new int[capacity];
        index =-1;
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull(){
        return index == capacity-1;
    }

    public int pop(){
        if(index >= 0){
            int data = this.data[index];
            index--;
            return data;
        }
        return -1;
    }

    public void push(int data){
        index++;
        this.data[index] = data;
    }

    public int peek(){
        return index > 0 ? data[index] : -1;
    }

    public static void main(String[] args) {
        int len = 20;
        Random random = new Random();
        Stack stack = new Stack(len);
        System.out.println("入栈顺序为：");
        for(int i=0; i<len; i++){
            int e = random.nextInt(len);
            System.out.print(e+"-->");
            stack.push(e);
        }
        System.out.println("\n出栈顺序为: ");
        while (!stack.isEmpty()){
            int e = stack.pop();
            System.out.print(e+"-->");
        }
    }

}

package org.example.stack;

/**
 *
 * 基于数组实现栈,index 反应
 */
public class Stack {
    int[] data;
    int index;
    public Stack(int capacity){
        data = new int[capacity];
        index =-1;
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

    public static void main(String[] args) {
        Stack stack = new Stack(100);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}

package com.cyfqz.basic.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphDemo {
    public static void main(String[] args) {
        List list =new ArrayList<>(10);
        Graph graph = new Graph();
        graph.addVerterx('A');//0
        graph.addVerterx('B');//1
        graph.addVerterx('C');//2
        graph.addVerterx('F');//3
        graph.addVerterx('E');//4
        graph.addEdg(0,1);
        graph.addEdg(1,2);
        graph.addEdg(2,3);
        graph.addEdg(3,4);
        graph.addEdg(4,0);
        System.out.println("深度优先遍历为：");
        graph.dfs();
        System.out.println("广度优先遍历为：");
        graph.bfs();
    }
}

/**
 *图的顶点信息
 */
class Vertex{
    private char label;
    private boolean isVisited;

    public Vertex(char label){
        this.label = label;
        this.isVisited = false;
    }

    public void display(){
        System.out.println(this.label);
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}

class Graph{
    private static final int maxVerterxSize = 20; // 图的顶点个数
    private Vertex[] vertices; // 用数组保存顶点数
    private int[][] adjMetrix; // 用二位数组保存邻接矩阵
    private int nVerterx; // 当前顶点个数

    private Queue queue;// 图广度优先遍历

    private Stack stack; // 图深度优先遍历

    public Graph(){
        vertices = new Vertex[maxVerterxSize];
        adjMetrix = new int[maxVerterxSize][maxVerterxSize];
        nVerterx = 0;
        for(int i = 0;i<maxVerterxSize;i++){
            for(int j= 0; j< maxVerterxSize;j++){
                adjMetrix[i][j]=0;
            }
        }
        queue = new Queue();
        stack = new Stack();
    }

    /**
     * 展示节点
     * @param index
     */
    public void displayVerterx(int index){
        System.out.println(this.vertices[index].getLabel());
    }

    /**
     * 返回顶点index邻接的图顶点
     * @param index
     * @return
     */
    public int getAdUnvisited(int index){
        for(int i=0;i<this.nVerterx;i++){
            if(this.adjMetrix[index][i] == 1 && this.vertices[i].isVisited() == false){
                return i;
            }
        }
        return -1;
    }

    /**
     * 添加顶点
     * @param label
     */
    public void addVerterx(char label){
        this.vertices[nVerterx++]=new Vertex(label);
    }

    /**
     * 添加边
     * @param start
     * @param end
     */
    public void addEdg(int start,int end){
        this.adjMetrix[start][end] = 1;
        this.adjMetrix[end][start] =1;
    }

    /**
     * 深度优先
     */
    public void dfs(){
        Vertex vertex = vertices[0];
        vertex.setVisited(true);
        this.displayVerterx(0);
        this.stack.push(0);
        while (!this.stack.isEmpty()) {
            int v = this.getAdUnvisited(this.stack.peek());
            if (v == -1) {
                this.stack.pop();
            } else {
                this.stack.push(v);
                this.displayVerterx(v);
                this.vertices[v].setVisited(true);
            }
        }

        for(int i=0;i<this.nVerterx;i++) {
            this.vertices[i].setVisited(false);
        }


    }

    /**
     * 广度优先
     */
    public void bfs(){
        Vertex vertex = vertices[0];
        vertex.setVisited(true);
        displayVerterx(0);
        this.queue.enQueue(0);
        int v2;
        while(! queue.isEmpty()) {
            int v = queue.deQueue();
            while ( (v2=getAdUnvisited(v)) != -1) {
                queue.enQueue(v2);
                displayVerterx(v2);
                vertices[v2].setVisited(true);
            }
        }

        for(Vertex v : vertices){
            v.setVisited(false);
        }
    }


}

class Stack{
    private int top;
    private static final int size = 20;
    private int[] stackArray;

    public Stack(){
        this.top = -1;
        stackArray = new int[20];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size -1;
    }

    public int pop(){
        return this.stackArray[top--];
    }

    public void push(int data){
        this.stackArray[++top] = data;
    }

    public int peek(){
        return this.stackArray[top];
    }
}

class Queue{
    private int front;
    private int rear;
    private int maxSize = 20 ;
    private int[] queueArray;

    public Queue(){
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public void enQueue(int data){
        queueArray[++rear] = data;
    }

    public int deQueue(){
        return queueArray[++front];
    }

    public int peek(){
        return queueArray[front];
    }

    public boolean isEmpty(){
        return rear == front && front == -1;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }
}

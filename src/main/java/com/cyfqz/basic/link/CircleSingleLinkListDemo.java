package com.cyfqz.basic.link;

import java.util.Random;

/**
 * 循环链表解决约瑟夫问题
 */
public class CircleSingleLinkListDemo {

    public static void main(String[] args) {
        CircleSingleLinkListDemo circleSingleLinkListDemo = new CircleSingleLinkListDemo();

        CircleSingleLinkList circleSingleLinkList = circleSingleLinkListDemo.new CircleSingleLinkList();
        int len = 10;
        Random random = new Random();
        for(int i=0; i<len;i++){
            circleSingleLinkList.insert(random.nextInt(10));
        }
        circleSingleLinkList.show();
        circleSingleLinkList.yusefu(1,2);
        circleSingleLinkList.show();



    }

    class Node{
        int data;

        boolean isOut;
        Node next;

        public Node(int data) {
            this.data = data;
            this.isOut = false;
        }


        public boolean isOut() {
            return isOut;
        }

        public void setOut(boolean out) {
            isOut = out;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    class CircleSingleLinkList{
        Node head;
        Node tail;
        int size;

        public CircleSingleLinkList(){
            head = tail = null;
        }

        public void insert(int key){
            Node node = new Node(key);
            if(size == 0){
                head = node;
                tail = node;
                tail.setNext(head);
                size++;
            }else {
                tail.setNext(node);
                node.setNext(head);
                tail = node;
                size++;
            }
        }

        public void yusefu(int startNum,int gap){
            // 移动位置
            for(int i=1;i<startNum;i++){
                head = head.getNext();
                tail = tail.getNext();
            }

            while (head != tail){
                for(int i=1;i<gap;i++){
                    if(i == 1){
                      head = head.getNext();
                    }
                    head = head.getNext();
                    tail = tail.getNext();
                }
                System.out.println("出局人员为："+tail.getNext().getData());
                tail.getNext().setOut(true);
                tail.setNext(head);
            }
        }

        public void show(){
            Node current = head;
            while (current.getNext() != head){
                System.out.print(current.getData());
                System.out.print("--->");
                current = current.getNext();
            }
            System.out.print(current.getData());
        }
    }

}
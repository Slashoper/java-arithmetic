package com.cyfqz.link;

import java.util.Random;

/**
 * 明白节点的抽象以及head 指针的使用,head 指针指向第一个节点
 */
public class LinkList {
    Node head;

    public LinkList(){
        this.head =null;
    }

    public boolean isEmty(){
        return head == null ? true : false;
    }

    /**
     * 插入节点
     * @param data
     */
    public void insertNode(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
        }else{
            node.next = head.next;
            head.next = node;
        }
    }

    public Node delete(){
        if ( isEmty() ){
            throw  new RuntimeException("the LinkList is emty,cannot delete.");
        }
        Node tmp = head;
        head = head.next;
        return tmp;
    }

    public void printList(){
        Node current = head; // 通过临时节点保存头节点,避免破坏链表的结构
        while ( current != null ) {
            System.out.print(current.data);
            System.out.print("-->");
            current = current.next;
        }
    }

    public Node search(int data){
        Node current = head; // 通过临时节点保存头节点，避免破坏链表的结构
        while ( current != null){
            if(current.data == data)
                return current;
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Random random = new Random();
        int len = 20;
        for(int i=0; i<len; i++){
            linkList.insertNode(random.nextInt(len));
        }
        linkList.printList();
        Node node = linkList.search(2);
        node.show();
    }
}


class Node{
    public int data;
    public Node next;

    public void show(){
        System.out.print(this.data);
    }
    public Node(int data){
        this.data = data;
    }
}
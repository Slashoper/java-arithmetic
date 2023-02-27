package com.cyfqz.leecode;

import java.util.Random;

public class LeeCode2 {

    public static void main(String[] args) {
        LinkList l1 = new LeeCode2.LinkList();
        LinkList l2 = new LeeCode2.LinkList();
        Random random = new Random();
//        for(int i = 0;i< 3;i++){
//            l1.insertNode(random.nextInt(10));
//        }
//        for(int i = 0;i< 4;i++){
//            l2.insertNode(random.nextInt(10));
//        }
        l1.insertNode(7);
        l1.insertNode(0);
        l1.insertNode(3);

        l2.insertNode(2);
        l2.insertNode(1);
        l2.insertNode(0);
        l2.insertNode(6);
        System.out.println("相加之前");
        l1.display();
        System.out.println();
        l2.display();
        System.out.println();
        LinkList rs = solution(l1.head,l2.head);
        rs.display();
    }

    public  static LinkList solution(Node l1,Node l2){

        LinkList rs = new LinkList();
        int carry = 0;
        while (l1 != null || l2 != null ){
            int e1 = l1 == null ? 0: l1.getData();
            int e2 = l2 == null ? 0: l2.getData();
            int sum = e1 + e2 + carry;
            int m = sum % 10;
            rs.insertNode(m);
            carry = sum / 10;
            if(l1 != null )
                l1 = l1.getNext();
            if(l2 != null )
                l2 = l2.getNext();
        }
        if(carry>0){
            rs.insertNode(carry);
        }
        return rs;
    }

   public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
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

    public static class LinkList{
        Node head;

        public LinkList(){
            head = null;
        }

        public void insertNode(int e){
            Node node = new Node(e);
            if(head == null){
                head = node;
            }else{
                Node tmp = head;
                while(tmp.getNext() != null){
                    tmp = tmp.getNext();
                }
                tmp.setNext( node );
//                node.setNext(head.getNext());
//                head.setNext(node);
            }
        }

        public void display(){
            if (head == null){
                return;
            }
            Node cur = head;
            while(cur!=null){
                System.out.printf("%d\t",cur.getData());
                cur = cur.getNext();
            }
        }
    }
}

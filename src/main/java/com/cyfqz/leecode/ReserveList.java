package com.cyfqz.leecode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * 反转链表
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/08/30 10:33
 */
public class ReserveList {
    public static void main(String[] args) {

        SelfList list = new SelfList();
        list.addNode(new Node(1));
        list.addNode(new Node(2));
        list.addNode(new Node(3));
        list.addNode(new Node(4));
        list.addNode(new Node(5));
        list.addNode(new Node(6));
        list.showList();
        System.out.println("#####################");
        list.process();
        list.showList();

    }

    static class SelfList{
        private Node head;


        /**
         * 链表反转的递归算法
         * @param head
         * @return
         */
        public Node reversList(Node head){
            if ( head == null || head.next == null ) return head;
            Node newNode = reversList(head.next);
            head.next.next = head;
            head.next = null;

            return newNode;
        }

        public void process(){
            head = reversList(head);
        }

        /**
         * 添加节点
         * @param node
         */
        public void addNode(Node node){
            Node cur = head;
            if (head == null)
                this.head = node;
            else{
                while(cur.next != null){
                    cur = cur.next;
                }
                cur.next = node;
            }

        }

        public void showList(){
            Node cur = head;
            if(head == null ){
                System.err.println("列表为null");
            }
            System.out.printf("%d\t",cur.val);
            while(cur.next!=null){
                cur = cur.next;
                System.out.printf("%d\t",cur.val);
            }
        }
    }

    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }


        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

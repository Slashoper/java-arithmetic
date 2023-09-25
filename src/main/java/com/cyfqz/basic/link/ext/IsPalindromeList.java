package com.cyfqz.basic.link.ext;

import com.cyfqz.basic.link.ext.s.Node;

import java.util.Stack;

/**
 * 是否是回文字符串
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/04 14:15
 */
public class IsPalindromeList {

    /**
     * 判断回文字符串
     * @param head
     * @return
     */
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur  = head;
        while(cur != null ){
            stack.push(cur);
            cur = cur.next;
        }
        while(head!=null){
            if(head.value != stack.peek().value){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // need n/2 extra space
    public  static boolean isPalindrome2(Node head){
        if ( head == null || head.next == null ){
            return true;
        }

        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Node> stack = new Stack<>();
        while(right != null ){
            stack.push(right);
            right = right.next;
        }

        while(!stack.isEmpty()){
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    // need O(1) extra space
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while(n2 != null){ // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }

        n3 = n1;
        n2 = head;
        boolean res =true;
        while(n1 != null && n2 !=null ){
            if ( n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next; // left ot mid
            n2 = n2.next; // right to mid
        }
        n1 = n3.next;
        n3.next = null;
        while(n1 != null){ // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }


}

package org.example.tree;

public class TreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i=0;i<10;i++){
            System.out.println(arr[i]);
        }
    }
}


class Node{
    private int data;
    Node leftChild;
    Node rightChild;

    public Node(int key){
        this.data = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

class Tree{
    Node root;

    public Tree(){
        root = null;
    }

    public Node searchNode(int key){
        return null;
    }

    public void insertNode(int key){
        Node node = new Node(key);
        if (this.root == null){
            this.root = node;
        }
        Node current = root;
        while(true){
            if ( current.getData() >= key){
                current = current.rightChild;
                if (current == null){
                    current = node;
                    return;
                }
            }
        }
    }
}

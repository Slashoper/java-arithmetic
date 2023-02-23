package com.cyfqz.tree;

import java.util.Scanner;

/**
 * @date
 */
public class TreeDemo {

    public static void main(String[] args) {
      Tree tree = new Tree();
      Scanner scanner = new Scanner(System.in);
      char menu;
      while (true){
          System.out.println("(i)往树里面插入节点");
          System.out.println("(s)往树里面查找节点");
          System.out.println("(t)往树里面查找节点");
          menu = scanner.next().charAt(0);
          int key;
          switch (menu){
              case 'i':
                  System.out.println("请输入你要插入的节点值");
                  key = scanner.nextInt();
                  tree.insertNode(key);
                  break;
              case 's':
                  System.out.println("请输入你要查询的节点值");
                  key = scanner.nextInt();
                  System.out.println(tree.searchNode(key).getData());
                  break;
              case 't':
                  System.out.println("请输入遍历类型[pre/in/post]");
                  String traverType = scanner.next();
                  tree.traverse(traverType);
                  break;
              default:
                  System.out.println("你输入的菜单不正确");
                  break;
          }
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
        if (root == null){
            throw  new RuntimeException("当前数没有元素");
        }
        Node current = root;
        while ( current.getData() != key){
            if(current.getData() > key ){
                current = current.leftChild;
                if (current == null)
                    return null;
            }else{
                current = current.rightChild;
                if(current == null)
                    return null;
            }
        }
        return current;
    }


    public  void traverse(String traverseType){
        switch (traverseType){
            case "in":
                inOrder(this.root);
                break;
            case "pre":
                preOrder(this.root);
                break;
            case "post":
                postOrder(this.root);
                break;
            default:
                System.out.println("你输入的遍历类型不正确");
                break;
        }
    }

    /**
     * 中序遍历，注意为什么要传入 Node root。因为要用到递归
     * @param root
     */
    public  static void inOrder(Node root){
        if ( root != null )
        {
            inOrder(root.leftChild);
            System.out.printf("%d\t",root.getData());
            inOrder(root.rightChild);
        }

    }



    public static void preOrder(Node root){
        if (root != null) {
            System.out.printf("%d\t", root.getData());
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }


    public static  void postOrder(Node root){
        if( root != null )
        {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.printf("%d\t",root.getData());
        }

    }

    public void insertNode(int key){
        Node node = new Node(key);
        if (this.root == null){
            this.root = node;
        }else{
            Node current = root;
            while(true){
                Node parent = current; // 要记录父亲节点，在父亲节点下挂子节点
                if ( current.getData() >= key){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }

    }
}

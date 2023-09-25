package com.cyfqz.basic.hashtreetable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

/**
 * hash表&有序表
 *
 * HashMap HashSet hash表
 *
 * TreeMap  TreeSet 有序表
 *
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/04 11:02
 */
public class HashAndTree {

    static class Node {
        public int value;
        public Node next;

        public Node(int val){
          value = val;
        }

    }


    public static class NodeComaretor implements Comparator<Node> {


        @Override
        public int compare(Node o1, Node o2) {
            return o1.value - o2.value;
        }
    }


    public static void main(String[] args) {



        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(3);
        System.out.println(hashSet1.contains(3));
        hashSet1.remove(3);
        System.out.println(hashSet1.contains(3));

        HashMap<Integer,String>  mapTest = new HashMap<>();
        mapTest.put(1,"张三");
        mapTest.put(2,"李四");
        mapTest.put(2,"2");
        System.out.println(mapTest.containsKey(1));
        System.out.println(mapTest.get(1));
        System.out.println(mapTest.get(4));


        TreeMap<Integer,String> treeMap1 = new TreeMap<>();
        treeMap1.put(7,"我是7");
        treeMap1.put(5,"我是5");
        treeMap1.put(4,"我是4");
        treeMap1.put(3,"我是3");
        treeMap1.put(9,"我是9");
        treeMap1.put(2,"我是2");
        System.out.println(treeMap1.containsKey(5));
        System.out.println(treeMap1.get(5));
        System.out.println(treeMap1.firstKey()+",我最小");
        System.out.println(treeMap1.lastKey()+"，我最大");
        System.out.println(treeMap1.floorKey(8)+",在表中所有<=8的数中，我离8最近");





    }
}

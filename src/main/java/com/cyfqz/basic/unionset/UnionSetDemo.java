package com.cyfqz.basic.unionset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 并查集算法讲解
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/02 20:54
 */
public class UnionSetDemo {


    public static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }


    public static class UnionFindSet<V> {
        public HashMap<V, Element<V>> elementMap;
        //每个节点代表的父节点
        public HashMap<Element<V>, Element<V>> fatherMap;
        // key 某个集合的代表元素，value表示该集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        /**
         * 找到节点e 的根节点
         *
         * @param e
         * @return
         */
        private Element<V> findHead(Element e) {
            Stack<Element> path = new Stack<>();
            while (e != fatherMap.get(e)) {
                path.push(e);
                e = fatherMap.get(e);
            }

            while (path.isEmpty()) {
                fatherMap.put(path.pop(), e);
            }

            return e;
        }

        /**
         * 查询a,b两个元素是否属于同一个集合
         *
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        /**
         * 合并两个集合
         * @param a
         * @param b
         */
        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aH = findHead(elementMap.get(a));
                Element<V> bH = findHead(elementMap.get(b));
                if (aH != bH) {
                    Element<V> big = sizeMap.get(aH) >= sizeMap.get(bH) ? aH : bH;
                    Element<V> small = big == aH ? bH : aH;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                    sizeMap.remove(small);
                }
            }
        }
    }
}

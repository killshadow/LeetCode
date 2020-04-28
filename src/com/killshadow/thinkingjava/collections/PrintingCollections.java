package com.killshadow.thinkingjava.collections;

import java.util.*;

public class PrintingCollections {
    static Collection
    fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }
    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>())); // 线性表
        System.out.println(fill(new LinkedList<>())); // 双向链表
        System.out.println(fill(new HashSet<>())); // 哈希集合, 不能含有重复的元素, 无序, 线程不安全
        System.out.println(fill(new TreeSet<>())); // 可以排序, 线程不安全
        System.out.println(fill(new LinkedHashSet<>())); // LinkedHashSet是一种有序的Set集合，即其元素的存入和输出的顺序是相同的
        System.out.println(fill(new HashMap<>())); // 类比于HashSet
        System.out.println(fill(new TreeMap<>())); // 类比于TreeSet
        System.out.println(fill(new LinkedHashMap<>())); // 类比于LinkedHashSet
    }
}
/** Output:
 * [rat, cat, dog, dog]
 * [rat, cat, dog, dog]
 * [rat, cat, dog]
 * [cat, dog, rat]
 * [rat, cat, dog]
 * {rat=Fuzzy, cat=Rags, dog=Spot}
 * {cat=Rags, dog=Spot, rat=Fuzzy}
 * {rat=Fuzzy, cat=Rags, dog=Spot}
 * */
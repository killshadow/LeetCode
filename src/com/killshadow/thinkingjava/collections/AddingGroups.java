package com.killshadow.thinkingjava.collections;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = new Integer[]{6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        System.out.println(collection.toString());
        List<Integer> integerList = Arrays.asList(moreInts);
        // 修改第一个元素的值为100
        integerList.set(0, 100);
        System.out.println(integerList.toString());

        /* java.lang.UnsupportedOperationException */
        // integerList.add(21);  // Runtime error; the underly array cannot be resized.
    }
}

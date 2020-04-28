package com.killshadow.thinkingjava.collections;

// collections/ListFeatures.java

import com.killshadow.thinkingjava.typeinfo.pets.*;

import java.util.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.list(7);
        System.out.println("1: " + pets);
        Hamster h = new Hamster();
        // 1. add方法
        pets.add(h); // Automatically resizes
        System.out.println("2: " + pets);
        // 2. contain方法
        System.out.println("3: " + pets.contains(h));
        // 3. remove方法
        pets.remove(h); // Remove by object
        // 4. get方法
        Pet p = pets.get(2);
        // 5. indexOf方法
        System.out.println(
                "4: " +  p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
        // Must be the exact object:
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        pets.add(3, new Mouse()); // Insert at an index
        System.out.println("9: " + pets);
        // 6. subList方法: 切割list
        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        // 7. sort方法: 对list排序
        Collections.sort(sub); // In-place sort
        System.out.println("sorted subList: " + sub);
        // Order is not important in containsAll():
        // 8. containAll: 检查是否包含入参list的所有元素(无序)
        List<Pet> copyPets = new LinkedList<>();
        copyPets.addAll(sub);
        copyPets.add(pets.get(5));
        System.out.println(pets + ":" + copyPets);
        System.out.println("11: " + pets.containsAll(copyPets));
        // 9. shuffle: 使用指定随机源对sub的元素置换
        Collections.shuffle(sub, rand); // Mix it up
        System.out.println("shuffled subList: " + sub);
        System.out.println("12: " + pets.containsAll(sub));
        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4), new Cymric());
        System.out.println("sub: " + sub);
        // 10. 保留copy中与sub重复的元素
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(pets); // Get a fresh copy
        copy.remove(pets.get(2)); // Remove by index
        System.out.println("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        System.out.println("15: " + copy);
        copy.set(1, new Mouse()); // Replace an element
        System.out.println("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear(); // Remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(Pets.list(4));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + pa[3].id());
    }
}
/* Output:
1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug]
2: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Hamster]
3: true
4: Cymric 2
5: -1
6: false
7: true
8: [Rat, Manx, Mutt, Pug, Cymric, Pug]
9: [Rat, Manx, Mutt, Mouse, Pug, Cymric, Pug]
subList: [Manx, Mutt, Mouse]
10: true
sorted subList: [Manx, Mouse, Mutt]
[Rat, Manx, Mouse, Mutt, Pug, Cymric, Pug]:[Manx, Mouse, Mutt, Cymric]
11: true
shuffled subList: [Mouse, Manx, Mutt]
12: true
sub: [Mouse, Pug, Cymric]
13: [Mouse, Pug]
14: [Rat, Mouse, Mutt, Pug, Cymric, Pug]
15: [Rat, Mutt, Cymric, Pug]
16: [Rat, Mouse, Cymric, Pug]
17: [Rat, Mouse, Mouse, Pug, Cymric, Cymric, Pug]
18: false
19: []
20: true
21: [Manx, Cymric, Rat, EgyptianMau]
22: EgyptianMau
23: 15
*/

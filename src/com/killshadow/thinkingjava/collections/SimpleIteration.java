package com.killshadow.thinkingjava.collections;

// collections/SimpleIteration.java
import com.killshadow.thinkingjava.typeinfo.pets.*;

import java.util.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        // 1. 集合都有iterator方法转为迭代器
        Iterator<Pet> it = pets.iterator();
        // 2. while循环的条件是迭代器还有下一个元素
        while(it.hasNext()) {
            // 3. 返回下一个元素
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
        // A simpler approach, when possible:
        for(Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for(int i = 0; i < 6; i++) {
            it.next();
            // 4. 删除元素
            it.remove();
        }
        System.out.println(pets);
    }
}
/* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
[Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
*/
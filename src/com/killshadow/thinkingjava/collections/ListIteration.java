package com.killshadow.thinkingjava.collections;

// collections/ListIteration.java
import com.killshadow.thinkingjava.typeinfo.pets.*;
import java.util.*;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        ListIterator<Pet> it = pets.listIterator();
        System.out.println(pets);
        // 1. while循环条件, 还有下一元素
        while(it.hasNext())
            // 2. 分别输出下一元素的idx和当前的index.
            System.out.print(it.next() +
                    ", " + it.nextIndex() +
                    ", " + it.previousIndex() + "; ");
        System.out.println();
        // Backwards:
        while(it.hasPrevious())
            System.out.print(it.previous().id() + " ");
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while(it.hasNext()) {
            it.next();
            // 3. Pets.get() 方法用来从位置 3 开始替换 List 中的所有 Pet 对象。
            it.set(Pets.get());
        }
        // 4. 回到上一步
        it.previous();
        it.previous();
        System.out.println(it.next());
        System.out.println(pets);
    }
}
/* Output:
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
Hamster
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*/

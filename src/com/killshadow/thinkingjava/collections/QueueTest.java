package com.killshadow.thinkingjava.collections;

import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> qs = new LinkedList<>();
        qs.addAll(Arrays.asList("A B C D E F G H I D Z".split(" ")));
        qs.offer("JJ");
        System.out.println(qs);
        // peek() 和 element() 都返回队头元素而不删除它，但是如果队列为空，
        // 则 element() 抛出 NoSuchElementException ，而 peek() 返回 null
        System.out.println("qs.peek: " + qs.peek());
        System.out.println("qs.element: " + qs.element());

        // poll() 和 remove() 都删除并返回队头元素，但如果队列为空，
        // poll() 返回 null ，而 remove() 抛出 *NoSuchElementException
        System.out.println("qs.remove: " + qs.remove());
        System.out.println("qs.poll: " + qs.poll());

        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20,
                18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<>(
                ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings =
                Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ =
                new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<>(
                strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);

        Set<Character> charSet = new HashSet<>();
        for(char c : fact.toCharArray())
            charSet.add(c); // Autoboxing
        PriorityQueue<Character> characterPQ =
                new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
    }

    public static class QueueDemo {
        public static void printQ(Queue queue) {
            while (queue.peek() != null)
                System.out.print(queue.remove() + " ");
            System.out.println();
        }
    }
}
/**Output:
 * [A, B, C, D, E, F, G, H, I, D, Z, JJ]
 * qs.peek: A
 * qs.element: A
 * qs.remove: A
 * qs.poll: B
 * 0 1 1 1 1 1 3 5 8 14
 * 1 1 2 3 3 9 9 14 14 18 18 20 21 22 23 25 25
 * 25 25 23 22 21 20 18 18 14 14 9 9 3 3 2 1 1
 *       A A B C C C D D E E E F H H I I L N N O O O O S S S T T U U U W
 * W U U U T T S S S O O O O N N L I I H H F E E E D D C C C B A A
 *   A B C D E F H I L N O S T U W
 * */

package com.killshadow.thinkingjava.collections;

import com.killshadow.thinkingjava.CollectionMethodDifferences;

public class CollectionDifferences {
    public static void main(String[] args) {
        CollectionMethodDifferences.main(args);
    }
}
/**Output:
 * Collection: [add, addAll, clear, contains, containsAll, equals, forEach, hashCode, isEmpty,
 *      iterator, parallelStream, remove, removeAll, removeIf, retainAll, size, spliterator, stream, toArray]
 *
 * Interfaces in Collection: [Iterable]
 *
 * Set extends Collection, adds: [copyOf, of]
 *
 * Interfaces in Set: [Collection]
 *
 * HashSet extends Set, adds: []
 *
 * Interfaces in HashSet: [Set, Cloneable, Serializable]
 *
 * LinkedHashSet extends HashSet, adds: []
 *
 * Interfaces in LinkedHashSet: [Set, Cloneable, Serializable]
 *
 * TreeSet extends Set, adds: [headSet, descendingIterator, descendingSet, pollLast, subSet,
 *      floor, tailSet, ceiling, last, lower, comparator, pollFirst, first, higher]
 *
 * Interfaces in TreeSet: [NavigableSet, Cloneable, Serializable]
 *
 * List extends Collection, adds: [replaceAll, get, of, indexOf, subList, set, sort, copyOf, lastIndexOf, listIterator]
 *
 * Interfaces in List: [Collection]
 *
 * ArrayList extends List, adds: [trimToSize, ensureCapacity]
 *
 * Interfaces in ArrayList: [List, RandomAccess, Cloneable, Serializable]
 *
 * LinkedList extends List, adds: [offerFirst, poll, getLast, offer, getFirst, removeFirst,
 *      element, removeLastOccurrence, peekFirst, peekLast, push, pollFirst, removeFirstOccurrence,
 *      descendingIterator, pollLast, removeLast, pop, addLast, peek, offerLast, addFirst]
 *
 * Interfaces in LinkedList: [List, Deque, Cloneable, Serializable]
 *
 * Queue extends Collection, adds: [poll, peek, offer, element]
 *
 * Interfaces in Queue: [Collection]
 *
 * PriorityQueue extends Queue, adds: [comparator]
 *
 * Interfaces in PriorityQueue: [Serializable]
 *
 * Map: [clear, compute, computeIfAbsent, computeIfPresent, containsKey, containsValue, copyOf,
 *      entry, entrySet, equals, forEach, get, getOrDefault, hashCode, isEmpty, keySet, merge, of,
 *      ofEntries, put, putAll, putIfAbsent, remove, replace, replaceAll, size, values]
 *
 * HashMap extends Map, adds: []
 *
 * Interfaces in HashMap: [Map, Cloneable, Serializable]
 *
 * LinkedHashMap extends HashMap, adds: []
 *
 * Interfaces in LinkedHashMap: [Map]
 *
 * SortedMap extends Map, adds: [lastKey, subMap, comparator, firstKey, headMap, tailMap]
 *
 * Interfaces in SortedMap: [Map]
 *
 * TreeMap extends Map, adds: [descendingKeySet, navigableKeySet, higherEntry, higherKey, floorKey,
 *      subMap, ceilingKey, pollLastEntry, firstKey, lowerKey, headMap, tailMap, lowerEntry, ceilingEntry,
 *      descendingMap, pollFirstEntry, lastKey, firstEntry, floorEntry, comparator, lastEntry]
 *
 * Interfaces in TreeMap: [NavigableMap, Cloneable, Serializable]
 * */
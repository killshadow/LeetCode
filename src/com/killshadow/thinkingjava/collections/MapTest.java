package com.killshadow.thinkingjava.collections;

import com.killshadow.thinkingjava.typeinfo.pets.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static final Map<Person, List< ? extends Pet>>
            petPeople = new HashMap<>();
    static {
        petPeople.put(new Person("Dawn"),
                Arrays.asList(
                        new Cymric("Molly"),
                        new Mutt("Spot")));
        petPeople.put(new Person("Kate"),
                Arrays.asList(new Cat("Shackleton"),
                        new Cat("Elsie May"), new Dog("Margrett")));
        petPeople.put(new Person("Marilyn"),
                Arrays.asList(
                        new Pug("Louie aka Louis Snorkelstein Dupree"),
                        new Cat("Stanford"),
                        new Cat("Pinkola")));
        petPeople.put(new Person("Luke"),
                Arrays.asList(
                        new Rat("Fuzzy"), new Rat("Fizzy")));
        petPeople.put(new Person("Isaac"),
                Arrays.asList(new Rat("Freckly")));
    }

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println("My Dog: " + dog);
        System.out.println("petMap.containsKey(\"My Dog\"): " + petMap.containsKey("My Dog"));
        System.out.println("petMap.containsValue(dog): " + petMap.containsValue(dog));

        System.out.println("--------------------------------------");

        System.out.println("People: " + petPeople.keySet());
        System.out.println("Pets: " + petPeople.values());
        for(Person person : petPeople.keySet()) {
            System.out.println(person + " has:");
            for(Pet pet : petPeople.get(person))
                System.out.println("    " + pet);
        }

        System.out.println("--------------------------------------");

        Map<String, Integer> week = new HashMap<>();
        week.put("Mon", 1);
        week.put("Tue",2);
        week.put("Wed",3);
        week.put("Thu",4);
        week.put("Fri",5);
        week.put("Sat",6);
        week.put("Sun",7);
        week.put("Wed", 10);
        week.put("FFF", 6);
        System.out.println(week);
    }
}
/**Output:
 * {My Dog=Dog Ginger, My Cat=Cat Molly, My Hamster=Hamster Bosco}
 * My Dog: Dog Ginger
 * petMap.containsKey("My Dog"): true
 * petMap.containsValue(dog): true
 * --------------------------------------
 * People: [Person Dawn, Person Kate, Person Isaac, Person Marilyn, Person Luke]
 * Pets: [[Cymric Molly, Mutt Spot], [Cat Shackleton, Cat Elsie May, Dog Margrett], [Rat Freckly], [Pug Louie aka Louis Snorkelstein Dupree, Cat Stanford, Cat Pinkola], [Rat Fuzzy, Rat Fizzy]]
 * Person Dawn has:
 *     Cymric Molly
 *     Mutt Spot
 * Person Kate has:
 *     Cat Shackleton
 *     Cat Elsie May
 *     Dog Margrett
 * Person Isaac has:
 *     Rat Freckly
 * Person Marilyn has:
 *     Pug Louie aka Louis Snorkelstein Dupree
 *     Cat Stanford
 *     Cat Pinkola
 * Person Luke has:
 *     Rat Fuzzy
 *     Rat Fizzy
 * --------------------------------------
 * {Thu=4, Tue=2, Wed=10, Sat=6, FFF=6, Fri=5, Mon=1, Sun=7}
 * */
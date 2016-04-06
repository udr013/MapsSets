package com.udr.hashsetcubessquares;

import sun.util.PreHashedMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by udr013 on 6-4-2016.
 */
public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("There are: " + squares.size() + " squares and " + cubes.size() + " cubes");

        Set<Integer> fullset = new HashSet<>(squares);
        fullset.addAll(cubes);

        System.out.println("Fullset contains " + fullset.size());


        /**
         * If the specified collection is also a set, this operation effectively modifies
         * this set so that its value is the intersection of the two sets.
         */

        System.out.println("++++ print the symetrics ++++\n");
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println(intersection.size());

        for (int i : intersection) {
            System.out.println(i + " is the square of(square root) " + Math.sqrt(i) + " " +
                    "and the cube of (cube root) " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");

        System.out.println("\n++++++ printing strings in  array ++++++++");
        for (String s : arrayWords) {
            System.out.println(s);
        }

        System.out.println("\n++++++ printing strings in  hashset, note \"the\"  is printed only once ++++++++");
        words.addAll(Arrays.asList(arrayWords));
        //remember hashset order is unpredictable! and doesn't take doubles! note "the"
        for (String s : words) {
            System.out.println(s);
        }


        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        /**
         * we can't put a "literal" in a set or map so we add them to an array first, and pass them to the Set
         * */
        String[] arrayNature = {"all", "nature", "is", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(arrayNature));
        String[] divineWords = {"to", "er", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("\n++++++++ getting the symmetric difference ++++++++");
        System.out.println("Nature takes divine: ");

        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);
        System.out.println("\ndivine takes nature: ");

        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> union = new HashSet<>(nature);
        union.addAll(divine);
        Set<String> intersection2 = new HashSet<>(nature);
        intersection2.retainAll(divine);
        System.out.println("\n symmetric differences: is the collection of all words minus the intersection");
        union.removeAll(intersection2);
        printSet(union);


        /**
         * containsAll() to test if one is a super st of the other
         * */
        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }else{
            System.out.println("divine is not a subset of nature");
        }

        if (nature.containsAll(intersection2)){
            System.out.println("intersection2 is a subset of nature");
        }

        if(divine.containsAll(intersection2)){
            System.out.println("intersection2 is a subset of divine");
        }

    }

    private static void printSet(Set<String> set) {
        System.out.println("\t");
        for (String s : set) {
            System.out.print(s+" ");
        }
        System.out.println();
    }

}


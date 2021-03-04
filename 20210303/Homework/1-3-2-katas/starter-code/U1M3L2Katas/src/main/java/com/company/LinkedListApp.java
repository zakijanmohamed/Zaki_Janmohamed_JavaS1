package com.company;

import java.util.LinkedList;

public class LinkedListApp {
    public static int total(LinkedList<Integer> numbers) {

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven(LinkedList<Integer> numbers) {

        int sum = 0;
        for (int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0);
        strings.set(0, strings.get(strings.size() - 1));
        strings.set(strings.size() - 1, temp);

        return strings;
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {

        LinkedList<Integer> reversed = new LinkedList<>();

        for (int i = 0; i < numbers.size(); i++) {

            reversed.add(numbers.get(numbers.size() - (i + 1)));
        }

        return reversed;
    }

    public static LinkedList<Integer> lessThanFive(LinkedList<Integer> numbers) {

        int numLessThanFive = 0;

        for (int num : numbers) {
            if (num < 5) {
                numLessThanFive++;
            }
        }

        if (numLessThanFive == 0) {
            return null;
        }

        LinkedList<Integer> lessThan = new LinkedList<>();

        for (int num : numbers) {
            if (num < 5) {
                lessThan.add(num);

            }
        }

        return lessThan;
    }
}

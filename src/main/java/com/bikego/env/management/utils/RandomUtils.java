package com.bikego.env.management.utils;

import java.util.HashSet;
import java.util.Set;

public class RandomUtils {

    public static int getRandom3Int() {
        return (int)(1000+Math.random()*(999-100+1));
    }

    public static int getRandom5Int() {
        return (int)(10000+Math.random()*(99999-10000+1));
    }

    public static int getRandom6Int() {
        return (int)(100000+Math.random()*(999999-100000+1));
    }
    public static int getRandomIntByMax(int max) {
        return (int)(Math.random()*(max));
    }

    public static Set<Integer> getIndexRanger(int max, int count) {
        Set<Integer> integerSet = new HashSet<>();

        if (count > max) {
            count = max;
        }

        while (true) {
            int index = getRandomIntByMax(max);
            if (integerSet.contains(index)) {
                continue;
            }

            integerSet.add(index);

            if (integerSet.size() >= count) {
                break;
            }
        }

        return integerSet;
    }

    public static void main(String[] args) {

        Set<Integer> set = getIndexRanger(2,10);
        System.out.println(set);
    }
}

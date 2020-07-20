package com.killshadow.thinkingjava.standardio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Echo {
    public static void main(String[] args) {
        new BufferedReader(
                new InputStreamReader(System.in))
                .lines()
                .forEach(System.out::println);
    }
}

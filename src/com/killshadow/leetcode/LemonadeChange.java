package com.killshadow.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * User: killshadow
 * Date: 2021/10/24 0024
 * Description:
 */
public class LemonadeChange {
    public static void main(String[] args) {
        LemonadeChange change = new LemonadeChange();
        System.out.println(change.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(change.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
        System.out.println(change.lemonadeChange(new int[]{5, 5, 10}));
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> coins = new HashMap<>();
        coins.put(5, 0);
        coins.put(10, 0);
        coins.put(20, 0);
        for (int bill : bills) {
            if (bill == 5) {
                coins.put(bill, coins.get(bill) + 1);
                continue;
            }
            int coin10 = coins.get(10);
            int coin5 = coins.get(5);
            if (bill == 20) {
                if (coin10 > 0 && coin5 > 0) {
                    coin5--;
                    coin10--;
                } else if (coin5 >= 3) {
                    coin5 -= 3;
                } else {
                    return false;
                }
            } else {
                if (coin5 > 0) {
                    coin5--;
                } else {
                    return false;
                }
            }
            coins.put(5, coin5);
            coins.put(10, coin10);
            coins.put(bill, coins.get(bill) + 1);
        }
        return true;
    }
}

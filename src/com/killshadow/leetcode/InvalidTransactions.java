package com.killshadow.leetcode;

import java.util.*;

public class InvalidTransactions {
    public static void main(String[] args) {
        InvalidTransactions invalidTransactions = new InvalidTransactions();
        List<String[]> strings = new ArrayList<>();
        strings.add(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"});
        strings.add(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"});
        strings.add(new String[]{"bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona",
                "bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam"});
        strings.add(new String[]{"bob,627,1973,amsterdam", "alex,387,885,bangkok", "alex,355,1029,barcelona",
                "alex,587,402,bangkok", "chalicefy,973,830,barcelona", "alex,932,86,bangkok", "bob,188,989,amsterdam"});

        for (String[] in : strings) {
            System.out.println(invalidTransactions.invalidTransactions(in).toString());
        }

    }

    public List<String> invalidTransactions(String[] transactions) {
        List<String> inValid = new ArrayList<>();
        List<Transaction> sameTrans = new ArrayList<>();

        for (String trans : transactions) {

            String[] info = trans.split(",");

            Transaction temp = new Transaction(info[0], Integer.valueOf(info[1]),
                    Integer.valueOf(info[2]), info[3]);

            if (temp.amount > 1000 && !inValid.contains(trans)) {
                inValid.add(trans);
            }

            for (Transaction tmp : sameTrans) {
                if (tmp.name.equals(temp.name) && !tmp.city.equals(temp.city) &&
                        (Math.abs(tmp.time - temp.time) <= 60)) {
                    if (!inValid.contains(trans)) {
                        inValid.add(trans);
                    }
                    if (!inValid.contains(tmp.toString())) {
                        inValid.add(tmp.toString());
                    }
                }
            }

            sameTrans.add(temp);

        }

        return inValid;
    }

    private class Transaction {
        String name;
        int time;
        int amount;
        String city;
        private Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }

        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}
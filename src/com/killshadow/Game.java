package com.killshadow;

public class Game {
    public static void main(String[] args) {

    }

    public int game(int[] guess, int[] answer) {
        int ans = 0;
        for (int i = 0; i < answer.length; i++) {
            if (guess[i] == answer[i]) {
                ans++;
            }
        }
        return ans;
    }
}

package com.killshadow.test;

public class BoardGame extends Game {
    public BoardGame(int i) {
        super();
        System.out.println("BoardGame constructor: " + i);
    }

    @Override
    public void player(int nums) {
        System.out.println("BoardGame players: " + nums);
        super.player(nums);
    }
}

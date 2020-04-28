package com.killshadow.test;

public class Chess extends BoardGame {
    public Chess(int i) {
        super(i);
        VAL_ONE = 100;
        System.out.println("Chess constructor: " + i);
    }
    public final int VAL_ONE;


    @Override
    public void player(int nums) {
        // VAL_ONE = nums; // invalid, 如果在这赋值, 编译器会报错
        System.out.println("Chess players: " + nums);
        super.player(nums);
    }

    public static void main(String[] args) {
        Chess chess = new Chess(1);
        chess.player(2);
    }
}

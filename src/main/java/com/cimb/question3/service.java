package com.cimb.question3;

public class service {
    public static void Question3() {
        int steps = 9;
        int result = WayToClimbStair(steps);
        System.out.println("There is : " + result + " To climb " + steps + " of stair");
    }
    public static int WayToClimbStair(int steps) {
        if (steps == 1)
            return 1;

        int[] tab = new int[steps+1];
        tab[0] = 1;
        tab[1] = 1;

        for (int i = 2; i <= steps; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[steps];
    }
}

package interview_camp.recursion_backtracking;

import java.util.LinkedList;

public class CoinChange {


    /*
        Given a set of coin demonination print all ways to add to up a give value

        * Position doesn't matter

        * Base case:
            * Remaining value == 0 -> Print
            * Remain value < 0 -> Return, bad combo
        * Generate successors
            * For each possible denomination from here on consider using it, don't need to consider previous
            demo since they will already enumerate this combo



           Example:

           Denom : [1,2,5]
           Target = 5


           # 1

           Value = 5
     */
    private static void coinChange(int[] coins, int value) {
        LinkedList<Integer> change = new LinkedList<>();
        coinChangeAux(coins, value, 0, change);

    }

    private static void coinChangeAux(int[] coins, int value, int index, LinkedList<Integer> change) {
        if (value == 0) {
            printChange(change);
            return;
        }

        if (value < 0) {
            return;
        }

        for (int i = index; i < coins.length; i++) {
            change.addLast(coins[i]);
            coinChangeAux(coins, value - coins[i], i, change);
            change.removeLast();
        }

    }

    private static void printChange(LinkedList<Integer> change) {
        for (int i : change) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 5);

    }
}

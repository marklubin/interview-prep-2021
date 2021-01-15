package interview_camp.recursion_backtracking;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Integer, Integer>  FIBS = new HashMap<>();

    private static int fib_dp_const(int n){
        int fib_1 = 1;
        int fib_2 = 1;

        for(int i = 3; i <= n; i++){
            int fib = fib_1 + fib_2;
            fib_2 = fib_1;
            fib_1 = fib;
        }

        return fib_1;
    }

    private static int fib_dp(int n){
        int[] fibs = new int[n+1];

        fibs[1] = 1;
        fibs[2] = 1;

        for(int i = 3; i <= n; i++){
            fibs[i] = fibs[i -1] + fibs[i -2];
        }

        return fibs[n];
    }

    private static int fib_memo(int n){
        if(FIBS.containsKey(n)){
            return FIBS.get(n);
        }

        if(n == 1 || n == 2){
            return 1;
        }

        int fib =  fib_memo(n -1 ) + fib_memo(n -2);
        FIBS.put(n, fib);
        return fib;
    }

    private static int fib_rec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib_rec(n - 1) + fib_rec(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib_rec(6));
        System.out.println(fib_memo(6));
        System.out.println(fib_dp(6));
        System.out.println(fib_dp_const(6));
    }
}

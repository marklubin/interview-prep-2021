package interview_camp.recursion_backtracking;

public class Power {

    /*
        Compute x^n, x & n can be +/- and don't need to consider overflow


        Base case x^0 = 1, x^1 = x, x^-1 = 1/x
        Recursion Relationship

        if n > 0 :
            x^n = x^(n-1) * x
        if n < 0 :
            x^n = x^(n+1) * 1/x

        Probably easier to just invert at the end?
     */
    private static double pow(int x, int n) {
        if (x == 0 && n <= 0) {
            throw new IllegalArgumentException("Undefined value.");
        }
        if (n == 1) {
            return x;
        }

        if (n == 0) {
            return 1.0  ;
        }

        if (n == -1) {
            return 1.0 / x;
        }

        if (n > 0) {
            return x * pow(x, n - 1);
        } else {
            return (1.0 / x) * pow(x, n + 1);
        }


    }

    public static void main(String[] args) {
        System.out.println(pow(2,4));
        System.out.println(pow(2,-4));
        System.out.println(pow(-2,4));
        System.out.println(pow(-2,-4));

        System.out.println(pow(-2,3));
        System.out.println(pow(-2,-3));


    }
}

package interview_camp.binary_search;

public class SquareRoot {

    private static int squareRoot(int n) {
        int start = 0;
        int end = n / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (square(mid) == n) {
                return mid;
            }
            if (square(mid) < n) {
                if (square(mid + 1) > n) {
                    return mid;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    private static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(0));
        System.out.println(squareRoot(4));
        System.out.println(squareRoot(5));
        System.out.println(squareRoot(8));
        System.out.println(squareRoot(9));
    }
}

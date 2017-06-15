public class FibonacciNumber {
    // dp solution with O(1) space
    public long fibonacci1(int K) {
        long a = 0;
        long b = 1;
        if (K <= 0) {
            return a;
        }
        while (K > 1) {
            long temp = a + b;    // sum of a and b first
            a = b;                // a becomes b
            b = temp;             // b becomes the sum
            K--;                  // K-- until K == 1, that time, b is what you need.
        }
        return b;
    }

    public static void main(String[] args) {
        FibonacciNumber fn = new FibonacciNumber();
        int[] lst = {0,1,2,3,6};
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "th - " + fn.fibonacci1(lst[i]));
        }
    }
}

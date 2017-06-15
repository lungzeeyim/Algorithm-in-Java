public class FibonacciNumber {
    // dp solution with O(1) space
    public long fibonacci1(int K) {
        long a = 0;
        long b = 1;
        if (K <= 0) {
            return a;
        }
        while (K > 1) {
            long temp = a + b;
            a = b;
            b = temp;
            K--;
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

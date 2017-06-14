// the class name "Power" 应该是和这个的文件名相同！否则不能编译！class Power == Power.java
public class Power {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        long half = power(a, b / 2);
        return b % 2 == 0? half * half : half * half * a;
    }
    public static void main(String[] args) {
        // power(2, 3) = 8
        long a1 = new Power().power(2, 3);
        System.out.println(a1);

        // power(-2, 5) = -32
        Power pw = new Power();
        long a2 = pw.power(-2,5);
        System.out.println(a2);
    }
}


/**
2 * 2 * 2 * 2 = 16

                 (2 , 4) 16
                   |      
                 (2, 2) 2 * 2 = 4
                   |
                 (2, 1) 1 * 1 * 2 = 2
                   |
                 (2, 0) 1

 **/

// javac Power.java
// java Power
// output: 16








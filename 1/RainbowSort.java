import java.util.Arrays;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int neg = 0;
        int one = array.length - 1;
        int zero = 0;
        while (zero <= one) {
            if (array[zero] == -1) {
                swap(array, neg++, zero++);
            } else if (array[zero] == 0) {
                zero++;
            } else {
                swap(array, zero, one--);
            }  
        }
        return array;
    }
    
    private void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    
    public static void main(String[] args) {
        RainbowSort rb = new RainbowSort();
        int[] array = new int[] {1,0,1,-1,0};
        array = rb.rainbowSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}

import java.util.Arrays;

public class Move0s {
    public int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {      // empty or size 1 array will be returned
            return array;
        }
        int left = 0;                                  // left pointer at the beginning
        int right = array.length - 1;                  // right pointer at the end
        
        while (left <= right) {                        // do it until they are pointing the same thing
            if (array[left] != 0) {                    // move the pointer to its right side if no zero found
                left++;
            } else if (array[right] == 0) {            // right pointer move to its left if it found a zero
                right--;
            } else {                                   // if left pointer found zero and right pointer found no zero,
                swap(array, left++, right--);          // then they can switch!!!
            }
        }
        return array;
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,0,1,0,4,3};
        Move0s mv = new Move0s();
        arr = mv.moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }
}

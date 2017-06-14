/** Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}

**/

import java.util.*; // for Arrays.toString

public class KClosest {
    public int[] KClosest(int[] array, int target, int k) { // sorted array, target number, k-size number
        if (array == null || array.length == 0) {     // empty array -> impossible to satisfy T -> return empty array
            return array;        
        }
        if (k == 0) {                     // if K(size num) is 0 -> return empty array
            return new int[0];
        }
        int left = largestSmallerEqual(array, target); // To T, find the largest smaller smaller element'index or equal element's index in the array;
        int right = left + 1;                          // right side of left is right...
        int[] result = new int[k];
        System.out.println(left + "  " + right);
        // create a new array with K size
        // merge operation
        for (int i = 0; i < k; i++) {
            System.out.println(left + "---" + right);
            if (right >= array.length        // right pointer is out of right bound
                || left >= 0                 // left pointer is not out of left bound 
                && target - array[left] <= array[right] - target)  { // diff between left and T <= diff between T and T ---> array[left] is closer to target
                result[i] = array[left--];  // move the left pointer to the left
            } else {
                result[i] = array[right++]; // move the right pointer to the right
            }
        }
        return result;
    }
    

    private int largestSmallerEqual(int[] array, int target) {
        // find the largest smaller smaller element'index or qual element's index in the array; 比它小里面最大的指
        int left = 0; // most left
        int right = array.length - 1; // most right
        while (left < right - 1) { // left pointer < right pointer -1 (backward)  => continue looping
            int mid = left + (right - left) / 2; // the way of finding the mid point
            if (array[mid] <= target) { // mid pointer's number <= target number ---> left pointer jump to mid
                left = mid;
            } else { // mid point's number > target ---> right pointer jump to mid 
                right = mid;
            }
        } // after this, pointers should be adjacent
          // 0 1 2 3 4 5          4
          //         L R
        if (array[right] <= target) { // right pointer's number <= T ---> choose right pointer
            return right;
        }
        if (array[left] <= target) { // left pointer's number <= T ---> choose left pointer
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3};
        int K = 3;
        int T = 2;
        KClosest kc = new KClosest();
        int[] arR = kc.KClosest(a1, T, K);
        System.out.println(Arrays.toString(arR));
    }
}

/**

1  2
1---2
0---2
-1---2
[2, 1, 3]

**/

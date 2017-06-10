/**
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array, and you can return any of the indices i such that A[i] == T.
Examples

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

i 是指数，T是那个位置的真数。
**/

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr1 = {1,2,2,2,3,4};
        int bs1 = bs.binarySearch(arr1, 2);
        System.out.println(bs1);

        int[] arr2 = {1,2,3,4,5};
        int bs2 = bs.binarySearch(arr2, 6);
        System.out.println(bs2);
    }

    // output:
    // 2
    // -1
}

// A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3
// A = {1, 2, 3, 4, 5}, T = 6, return -1

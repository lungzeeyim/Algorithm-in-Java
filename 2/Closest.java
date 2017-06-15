public class Closest {
    public int closest(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right - 1) {  // left and right , you 2 ge
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
            System .out.println(left + " - " + right);
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {  // 相差距离比较
            return left;
        }
        return right;
    }

    public static void main (String[] args) {
        Closest clo = new Closest();
        int[] arr1 = {1,4,6};
        int an = clo.closest(arr1, 5);
        System.out.println(an);
    }
}

/**
A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2

 **/

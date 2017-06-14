public class LastOccur {
    public int lastOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        LastOccur lo = new LastOccur();
        int[] arr1 = {1,2,2,2,3};
        int re = lo.lastOccur(arr1, 2);
        System.out.println(re); // return 3
    }
}

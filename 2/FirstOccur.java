public class FirstOccur {
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;

        while (left  < right - 1) {  // make sure there is no infinite loop
            int mid = left + (right -left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
            System.out.println(left + " - " + right);
        }


        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccur fo = new FirstOccur();
        int[] arr1 = {1,2,2,2,3};  // T = 2, should return 2
        int firstO = fo.firstOccur(arr1,1);
        System.out.println(firstO);
    }
}

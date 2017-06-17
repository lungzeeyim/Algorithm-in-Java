import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null) {   // null check
            return array;
        }
        int[] helper = new int[array.length];   // create a new array that has the same size as object array
        mergeSort(array, helper, 0, array.length - 1);   // merge it with obj array, same size empty array,
        return array;                                    // boundry-left, boundry-right
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {   // left pointer greater than right, means it is finished 
            return;            // return "nothing", mean recursion ends
        }
        int mid = left + (right - left) / 2 ;  // typical mid pointer solution
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);   // call itself
        merge(array, helper, left, mid, right); // merge
    }

    private void  merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {  // copy all elements to helper array
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
    }

    public static void main(String[] args) {
        MergeSort mg = new MergeSort();
        int[] array = null;
        array = mg.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[0];
        array = mg.mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {4,3,2,1};
        array = mg.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}

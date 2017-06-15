import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        if (array == null || array.length <= 1) {   // check condition
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {  // loop the array
            int min = i;
            for (int j = i + 1; j < array.length; j++) { // loop the array again by the next of i
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        SelectionSort sl = new SelectionSort();

        int[] array = null;
        array = sl.selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[] {4,3,2,1};
        array = sl.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
    
}

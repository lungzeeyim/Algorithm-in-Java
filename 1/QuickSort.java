import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {   // its over, if left pointer pass right pointer
            return;
        }
        
        // define a pivot 
        int pivotPos = partition(array, left, right);  // use the  pivot to partition the array
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];

        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftbound <= rightBound) {
            if (array[leftBOund] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                sway(array, leftBound++, rightBound--);
            }
        }
        sway(array, leftBound, right);
        return leftBound;
    }    
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.ramdom() * (right - left + 1));
    }
        
    private void sawp(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] array = new int[] {4,3,2,1};
        array = qs.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

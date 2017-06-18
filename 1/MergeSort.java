import java.util.Arrays;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        if (array == null) {                                 // null check
            return array;
        }
        int[] helper = new int[array.length];                // create a new array that has the same size as object array
        mergeSort(array, helper, 0, array.length - 1);       // merge it with obj array, same size empty array,
        return array;                                        // boundry-left, boundry-right
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {                                 // left pointer greater than right, means it is finished 
            return;                                          // return "nothing", mean recursion ends
        }
        int mid = left + (right - left) / 2 ;                // typical mid pointer solution
        //System.out.println(" left" + left + "Mid" + mid);
        mergeSort(array, helper, left, mid);                 // sort left pat
        //System.out.println("mid+1 " + (mid + 1) + " right" + right);
        mergeSort(array, helper, mid + 1, right);            // sort right part
        //System.out.println("merge L" + left + " M " + mid + " R " + right);
        merge(array, helper, left, mid, right);              // merge
        //System.out.println(Arrays.toString(array));
    }

    private void  merge(int[] array, int[] helper, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {                // copy all elements to helper array
            helper[i] = array[i];    
        }
        int leftIndex = left;                                // left part start point
        int rightIndex = mid + 1;                            // right part start point
        System.out.println(left + "---" + right);            // ------------------------output
        while (leftIndex <= mid && rightIndex <= right) {    // looping when left start point <= mid and
                                                             //              right start point <= right bound
            //System.out.println("leftIndex" + leftIndex + "rightIndex" + rightIndex + "mid" + mid + "left" + left + "right" + right);
            if (helper[leftIndex] <= helper[rightIndex]) {   // right side is greater
                array[left++] = helper[leftIndex++];         //  
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            //System.out.println(Arrays.toString(array));
            //System.out.println("leftIndex" + leftIndex + "mid" + mid);
            array[left++] = helper[leftIndex++];
        }
        System.out.println(Arrays.toString(array));          // -----------------------outpout!
    }

    public static void main(String[] args) {
        MergeSort mg = new MergeSort();
        int[] array = null;
        /**
        array = mg.mergeSort(array);
        System.out.println(Arrays.toString(array));
        
        array = new int[0];
        array = mg.mergeSort(array);
        System.out.println(Arrays.toString(array));
        **/
        array = new int[] {4,2,1};
        array = mg.mergeSort(array);
        //System.out.println(Arrays.toString(array));
    }
}

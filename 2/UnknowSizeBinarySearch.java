import java.util.HashMap; // hashmap can be dictionary
import java.util.Dictionary;

/**
A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 **/

public class UnknowSizeBinarySearch {
    public int search(HashMap dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0;  // initialize the left pointer to the most left
        int right = 1; // initialize the right pointer to right side to left pointer
        while (dict.get(right) != null &&    // right pointer's num must exist ---> not out of boundary
               dict.get(right).hashCode() < target)     // right pointer's num must smaller than Target
            {
                left = right;                // move left pointer to right pointer
                right = 2 * right;           // double right index
            }
        return binarySearch(dict, target, left, right);
    }

    private int binarySearch(HashMap dict, int target, int left, int right) {
        while (left <= right) {  // cotinue looping when left pointer is not to the right of right pointer.
            int mid = left + (right - left) / 2;  // typicall mid pointer solution
            if (dict.get(mid) == null ||           // mid pointer's num exist
                dict.get(mid).hashCode() > target)      // mid pointer's num is greater than target
                {                            // then right pointer jump to the left side of mid point
                    right = mid - 1; 
                }
            else if (dict.get(mid).hashCode() < target) // mid point's num less than
                {
                    left = mid + 1;           // ---> left pointer jump to the right side of mid point
                }
            else
                {
                    return mid;
                }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        dict.put(0,1);
        dict.put(1,2);
        dict.put(2,5);
        dict.put(3,9);
        dict.put(4,12);
        int target = 7;
        UnknowSizeBinarySearch ub = new UnknowSizeBinarySearch();
        int re = ub.search(dict, target);
        System.out.println(re);
        System.out.println(ub.search(dict, 5));
    }

    /**
       output:
         -1
         2
     **/
}

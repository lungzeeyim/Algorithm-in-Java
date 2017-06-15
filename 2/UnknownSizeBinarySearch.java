import java.util.*;

public class UnknownSizeBinarySearch {
    public int search(Dictionary dict, int target) {
        if (dictionary == null) {  // 如果dict为空，当然是返回-1啦
            return -1;
        }
        int left = 0;              // initialize left pointer to 0
        int right = 1;             // initialize right pointer to 1
        while (dict.get(right) != null          // right pointer is  not null
               && dict.get(right) < target) {   // right pointer also need to target
            left = right;
            right = 2 * right;
        }
        //return binarySearch(dictionary, target, left, right);
    }

    //private int binarySearch(Dictionary dict, int target, int left, int right) {
        
    //}

    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        dict.put(0,1);
        dict.put(1,2);
        dict.put(2,3);
        int T = 7;
        UnknowSizeBinarySearch usb = new UnknowSizeBinarySearch();
        //usb.search(dict, T);
//System.out.println(usb.search(dict, T));
    }
}

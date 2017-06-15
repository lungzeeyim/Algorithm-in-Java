import java.util.Arrays;          // Array.toString
public class SearchInSortedMatrix {
    // method 1: convert 2D array to 1D
    public int[] searchI(int[][] matrix, int target) {
        if (matrix.length == 0 ||              // row is empty
            matrix[0].length == 0)             // column is empty
            {
                return new int[] {-1,-1}; 
            }
        int rows = matrix.length;            // num of row
        int cols = matrix[0].length;         // num of col           assume every row are same size and every col are same size
        int left = 0; // initialize pointer to the most left
        int right = rows * cols - 1;         // size - 1, 0,1,2...  ---> converting 2D array to 1D array
        while (left <= right) {              // when left pointer is the right side of right pointer.
            int mid  = left + (right - left) /2;  // typical mid pointer solution
            // converting the postion in 1D array to 2D
            int row = mid / cols;       // ?             
            int col = mid % cols;       // ?
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        SearchInSortedMatrix sm = new SearchInSortedMatrix();
        int[][] matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} };
        int target = 7;
        String re = Arrays.toString( sm.searchI(matrix,target) );
        System.out.println(re);
    }
}

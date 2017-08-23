/*  K-th Smallest Number In Sorted Matrix 

Assume: 
matrix is not null
k > 0
k <= K*M (rows * columns)

*/

import java.util.*;

public class KthSmallestNum {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Best First Search, 每个值需要一个minheap
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
                @Override
                public int compare(Cell c1, Cell c2) {
                    if (c1.value == c2.value) {
                        return 0;
                    }
                    return c1.value < c2.value ? -1 : 1;
                }
            });
        // 新生成的对象cell默认开始是true
        // 避免了多次生成同一个对象
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
            
        }
        return minHeap.peek().value;
        
    }
    
    static class Cell {
        int row;
        int column;
        int value;
        
        Cell (int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
    
    public static void main(String[] args) {

        /*
          
          2 4 
          3 8
          
        */
        
        int[][] matrix = new  int[2][2];
        matrix[0][0] = 2;
        matrix[0][1] = 4;
        matrix[1][0] = 3;
        matrix[1][1] = 8;
        KthSmallestNum kth = new KthSmallestNum();
        // 2 3 4 8
        System.out.println(kth.kthSmallest(matrix, 1));
        System.out.println(kth.kthSmallest(matrix, 2));
        System.out.println(kth.kthSmallest(matrix, 3));
        System.out.println(kth.kthSmallest(matrix, 4));
        
        /* output: 
           2
           3
           4
           8
        */
    }
    
}























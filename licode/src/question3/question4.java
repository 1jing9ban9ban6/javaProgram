package question3;

import com.sun.corba.se.impl.orb.ParserTable;

public class question4 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                                     {2, 5, 8, 12, 19},
                                     {3, 6, 9, 16, 22},
                                     {10, 13, 14, 17, 24},
                                     {18, 21, 23, 26, 30}};
        question4 question4 = new question4();
        boolean b = question4.findNumberIn2DArray(matrix, 20);
        System.out.println(b);
    }
    public boolean findNumberIn2DArray (int[][] matrix, int target){
        if (matrix==null){
            return false;
        }
        int x = 0;
        int y = matrix[x].length-1;
        if (target>matrix[matrix.length-1][y] || target<matrix[0][0]){
            return false;
        }
        while (true){
            int num = matrix[x][y];
            if (num==target){
                return true;
            } else if (num>target){
                y--;
                if (y<0) {
                    return false;
                }
            } else {
                x++;
                if (x>matrix.length-1) {
                    return false;
                }
            }
        }
    }
}

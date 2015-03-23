public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        
        int[][] matrix = new int[n][n];
        
        
        // pointer
        int x = 0;
        int y = 0;
        
        int counter = 1;
        
        
        while (n > 0) {
            if (n == 1) {
                matrix[x][y] = counter;
                break;
            }
            
            for (int j = 0; j < n - 1; j++) {
                matrix[x][y++] = counter;
                counter++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[x++][y] = counter;
                counter++;
            }
            
            for (int j = 0; j < n - 1; j++) {
                matrix[x][y--] = counter;
                counter++;
            }
            
            for (int i = 0; i < n - 1; i++) {
                matrix[x--][y] = counter;
                counter++;
            }
            
            x++;
            y++;
            
            n -= 2;
        }
        
        return matrix;
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //reverse
        for(int i = 0; i<n/2; i++){
            
            int[] temp = matrix[i];
            matrix[i] = matrix[n-i-1];
            matrix[n-i-1] = temp;
        }

        //transpose
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }  
    }
}

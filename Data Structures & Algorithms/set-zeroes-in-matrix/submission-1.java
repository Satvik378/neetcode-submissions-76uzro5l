class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        //we can use the first row and first col as placeholders
        //for 0,0 we maintain a new var
        boolean rowZero = false;
        boolean colZero = false;
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(matrix[i][j] == 0){
                    
                    if(j > 0){
                        matrix[i][0] = 0; //set col to zero
                    }
                    else{
                        colZero = true;
                    }
                   

                    if(i > 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        rowZero = true;
                    }
                }
            }
        }

        for(int i = 1; i<rows; i++){
            for(int j = 1; j<cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(colZero){
            for(int i = 0; i<rows; i++){
                matrix[i][0] = 0; //first col is filled with 0
            }
        }

        if(rowZero){
            for(int i = 0; i<cols; i++){
                matrix[0][i] = 0;
            }
        }

    }
}

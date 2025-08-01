class Solution {
    public void setMatrixZeroes(int[][] matrix) {
        // code here
        boolean firstRow = false, firstCol=false;
        
        // check if the first row or column are 0
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i==0) firstRow = true;
                    if(j==0) firstCol = true;
                    
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        
        // ignore the first R and C
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] ==0){
                    matrix[i][j] =0;
                }
            }
        }
        
        // now go to first row
        if(firstRow){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j]=0;
            }
        }
        // now go to first col
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
    }
}
}
}
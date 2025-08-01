class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] matrix) {
        // code here
        ArrayList <Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length==0){
            return result;
        }
        
        int startRow =0;
        int startCol =0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        
        while(startRow <= endRow && startCol <= endCol ){
            
            // top row
            for(int j=startCol; j<= endCol; j++){
                result.add(matrix[startRow][j]);
            }
            // doun
            for(int i=startRow+1; i<=endRow;i++){
                result.add(matrix[i][endCol]);
            }
            
            // right to left
            if(startRow<endRow){
                for(int j=endCol-1; j>=startCol; j--){
                    result.add(matrix[endRow][j]);
                }
            }
            // up
            if(startCol<endCol){
                for(int i=endRow-1; i>startRow; i--){
                    result.add(matrix[i][startCol]);
                }
            }
            
            startRow ++;
            startCol ++;
            endRow--;
            endCol--;
            
        }
        
        return result;
    }
}

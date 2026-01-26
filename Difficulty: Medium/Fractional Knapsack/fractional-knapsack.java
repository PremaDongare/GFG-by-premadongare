class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        //to bind val and weig index together
        int n = val.length;
        Integer[]index = new Integer[n];
        for(int i=0; i<n; i++){
            index[i]=i;
        }
        
        //sort
        Arrays.sort(index,(i,j)->{
            double r1= (double) val[i]/wt[i];
            double r2 = (double) val[j]/wt[j];
            return Double.compare(r2,r1); //descending
        });
        
        double totalval=0.0;
        
        // fill knapsack
        for(int i=0; i<n && capacity >0 ; i++){
            int idx=index[i];
            if(wt[idx]<= capacity){
                //take full 
                totalval += val[idx];
                capacity -= wt[idx];
            }else{
                //take factor (120)      *     20       /   30;           
                totalval+= val[idx]*((double) capacity / wt[idx]);
                capacity =0;
            }
        }
        return totalval;
        
    }
}
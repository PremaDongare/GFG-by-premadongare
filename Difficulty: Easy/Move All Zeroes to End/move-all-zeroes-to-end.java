class Solution {
    void pushZerosToEnd(int[] nums) {
        // code here
        int n = nums.length;
        int  j=0;
        
        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i]= nums[j];
                nums[j]= temp;
                j++;
            }
        }
    }
}
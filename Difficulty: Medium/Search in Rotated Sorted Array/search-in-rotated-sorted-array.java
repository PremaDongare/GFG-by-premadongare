class Solution {
    int search(int[] arr, int target) {
        // code here
        int left =0;
        int right = arr.length-1;
        
        while(left<=right){
        int mid = left+(right-left)/2;
        
        if(arr[mid] == target)
         return mid;
         
         // check left is sorted or not
         
         if(arr[left] <= arr[mid]){
             // search
             
             if(arr[left] <= target && target < arr[mid]){
                 right = mid-1;
             }else{
                 left = mid+1;
             }
         }else{
             // check right is sorted or not
             
             if(arr[mid] < target && target <= arr[right]){
                 left = mid+1;
             }else{
                 right = mid-1;
             }
         }
        
        
        }
        
        return -1;
    }
}
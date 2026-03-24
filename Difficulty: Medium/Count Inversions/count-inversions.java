class Solution {
    
    //function to merge two halfs 
    
    public int merge(int[] arr, int low, int mid, int high){
        // temp arr
        int[]temp = new int[high-low+1];
        
        int left = low;
        int right = mid+1;
        int k=0;
        
        int cnt =0;
        
        //merge element in sorted order
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[k++]= arr[left++];
            }else{
                temp[k++] = arr[right++];
                cnt +=(mid -left +1); 
            }
        }
        
        //copy remaining left
        while(left <= mid){
            temp[k++]=arr[left++];
        }
        //copy remaining left
        while(right <= high){
            temp[k++]=arr[right++];
        }
        //copy back to original arr
        for(int i=low; i<=high; i++){
            arr[i]= temp[i-low];
        }
        return cnt;
        
    }
    
     public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high) return cnt;

        int mid = (low + high) / 2;

        // Count inversions in left half
        cnt += mergeSort(arr, low, mid);
        // Count inversions in right half
        cnt += mergeSort(arr, mid + 1, high);
        // Count inversions during merge
        cnt += merge(arr, low, mid, high);

        return cnt;
    }
    public int inversionCount(int arr[]) {
         return mergeSort(arr, 0, arr.length - 1);
        
    }
}
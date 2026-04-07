class Solution {
    public double medianOf2(int nums1[], int nums2[]) {
        // Code Here
        int []smaller = nums1.length > nums2.length ?nums2 : nums1;
        int []large = nums1.length > nums2.length ? nums1 : nums2;
        
        int totallength = nums1.length+nums2.length;
        
        int low=0, high = smaller.length;
        
        while(low<=high){
            int partationx = (low+high)/2;
            int partationy = (totallength+1)/2 -partationx;
            
            int l1 = partationx == 0 ?Integer.MIN_VALUE : smaller[partationx-1];
            int r1 = partationx == smaller.length? Integer.MAX_VALUE:smaller[partationx];
            
            int l2 = partationy == 0 ?Integer.MIN_VALUE : large[partationy-1];
            int r2 = partationy == large.length? Integer.MAX_VALUE:large[partationy];
            
            
            if(l1<= r2 && l2<= r1)
            //means valid 
            if((totallength) % 2 == 0)
            return (Math.max(l1,l2)+ Math.min(r1,r2)) /2.0;
            else
            return Math.max(l1,l2);
            
            if(l1>r2) high = partationx-1;
            else low = partationx+1;
        }
        return 0;
    }
}
class Solution {
    public int totalElements(int[] arr) {
        // code here
        int l=0, maxf =0;
        Map<Integer, Integer> fre= new HashMap<>();
        for(int r=0; r<arr.length; r++){
            fre.put(arr[r],fre.getOrDefault(arr[r],0)+1);
            while(fre.size()>2){
                fre.put(arr[l],fre.get(arr[l])-1);
                if(fre.get(arr[l]) == 0){
                    fre.remove(arr[l]);
                }
                l++;
            }
            maxf = Math.max(maxf, r-l+1);
        }
        return maxf;
        
    }
}
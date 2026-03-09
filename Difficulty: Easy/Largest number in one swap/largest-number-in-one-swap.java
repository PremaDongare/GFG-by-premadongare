class Solution {
    public String largestSwap(String s) {
        // code here
        char arr[]= s.toCharArray();
        int index[] = new int[10]; // store index of char
        
        for(int i=0; i<arr.length; i++){
            index[arr[i]-'0']=i; // assign index
        }
        
        // traverse arr again
        for(int i=0; i<arr.length;i++){
            int curr = arr[i] - '0';
            
            //traverse from back for biggen no
            for(int d=9; d>curr;d-- ){
                if(index[d]>i){
                    char temp = arr[i];
                    arr[i] = arr[index[d]];
                    arr[index[d]]= temp;
                    
                    return new String(arr);
                    
                }
            }
            
        }
        return s;
        
    }
}
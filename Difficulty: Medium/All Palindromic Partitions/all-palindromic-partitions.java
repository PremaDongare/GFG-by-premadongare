class Solution {
    
  
    
    private boolean isPalindron (String s, int l, int r ){
        while(l<r){
            if(s.charAt(l) != s.charAt(r))
                 return false;
                 l++;
                 r--;
        }
        return true;
    }
    
    private void backtrack(String s, int idn, List<String> curr,  List<ArrayList<String>> result ){
        if(idn == s.length()){
        result.add(new ArrayList<>(curr));
        return;
        }
        // backtrack
        
        for(int i=idn; i<s.length();i++ ){
            if(isPalindron(s,idn,i)){
                //do
                curr.add(s.substring(idn,i+1));
                // explore
                backtrack(s,i+1,curr,result);
                
                // backtrack
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public ArrayList<ArrayList<String>> palinParts(String s) {
        
       ArrayList<ArrayList<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        backtrack(s,0,curr,result);
        
        return result;
    }
}

class Solution {
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> ans = new ArrayList<>();
        
        // start recursion
        solve(s, 0, 0, "", ans);
        
        return ans;
    }
    
    void solve(String s, int index, int parts, String curr, ArrayList<String> ans){
        
        //if 4 parts are formed 
        if(parts==4 && index == s.length()){
            ans.add(curr.substring(0, curr.length()-1)); // to remove last dot
            return;
        }
        
        if(parts == 4 || index == s.length()){
            return;
        }
        
        //try all dig
        for(int len =1; len <= 3; len++){
            if(index + len > s.length())
            break;
            
            String part = s.substring(index, index+len);
            
            //check
            if(isValid(part)){
                solve(s, index+len, parts+1, curr +part +".",ans);
            }
        }
        
    }
    
    //valid ip or not 
    boolean isValid(String part){
        if(part.length()>1 && part.charAt(0) == '0')
        return false;
        
        int num = Integer.parseInt(part);
        
        if(num >= 0 && num <= 255)
        return true;
        
        return false;
        
        
        
        
        
        
    }
}
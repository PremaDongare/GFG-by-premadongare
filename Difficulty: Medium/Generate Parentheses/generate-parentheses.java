class Solution {
    public ArrayList<String> generateParentheses(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        int pairs = n / 2;  
        
        solve(result, "", 0, 0, pairs);
        return result;
    }
    
    public void solve(ArrayList<String> result, String curr, int open, int close, int pairs) {
        
        // base case
        if (curr.length() == 2 * pairs) {
            result.add(curr);
            return;
        }
        
        // add '('
        if (open < pairs) {
            solve(result, curr + "(", open + 1, close, pairs);
        }
        
        // add ')'
        if (close < open) {
            solve(result, curr + ")", open, close + 1, pairs);
        }
    }
}
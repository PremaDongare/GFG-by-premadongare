class Solution {
    
        // code here
        private String generate(String s) {
        int [] count = new int[26];
        
        for(char ch : s.toCharArray()){
            count[ch -'a']++;
        }
        
        // key writning process
        StringBuilder news = new StringBuilder();
        for(int i=0; i<26; i++){
            if(count[i]>0){
                news.append(String.valueOf((char) (i+'a')).repeat(count[i]));
            }
        }
        
        return news.toString();
        
    }
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        
        for(String s:strs){
            String news = generate(s);
            
            if(!map.containsKey(news)){
                map.put(news,new ArrayList<>());
            }
            
            map.get(news).add(s);
        }
        
    return new ArrayList<>(map.values());
}
}

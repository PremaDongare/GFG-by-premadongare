class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        StringBuilder encoded = new StringBuilder();
        for(String str:s){
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        List<String> decodeList= new ArrayList<>();
        int i=0;
        while(i<s.length()){
            int j=i;
            while(s.charAt(j)!='#'){
                j++;
            }
            // extract length
            int length = Integer.parseInt(s.substring(i,j));
            // extract word
            String word = s.substring(j+1, j+1+length);
            decodeList.add(word);
            
            // move i
            i= j+1+length;
            
        }
        return decodeList.toArray(new String[0]);
    }
}
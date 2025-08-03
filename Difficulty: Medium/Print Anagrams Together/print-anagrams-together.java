class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        // Now convert map.values() into ArrayList<ArrayList<String>>
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            result.add(new ArrayList<>(group)); 
        }

        return result;
    }
}

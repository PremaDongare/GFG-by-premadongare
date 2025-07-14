import java.util.*;

class Solution {
    public int longestUniqueSubstr(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                char current = s.charAt(j);

                if (set.contains(current)) {
                    break; 
                }

                set.add(current);
                maxCount = Math.max(maxCount, j - i + 1);
            }
        }

        return maxCount;
    }
}

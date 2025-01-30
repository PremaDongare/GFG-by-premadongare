//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            List<Integer> start = new ArrayList<>();
            for (String s : startInput) {
                start.add(Integer.parseInt(s));
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            List<Integer> end = new ArrayList<>();
            for (String s : endInput) {
                end.add(Integer.parseInt(s));
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, end));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
        // sorting
         // sorting
        int activities[][] = new int[start.size()][3];
        for (int i = 0; i < start.size(); i++) {
            activities[i][0] = i;      // activity index
            activities[i][1] = start.get(i);   // start time
            activities[i][2] = end.get(i);     // end time
        }

        // sorting by end time (activities[i][2])
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2])); // 2 for ending time

        int maxAct = 1; // First activity is always selected
        int lastEnd = activities[0][2]; // End time of the first activity

        // Iterate through the remaining activities
        for (int i = 1; i < end.size(); i++) {
            if  (activities[i][1] > lastEnd) {
                maxAct++; // Activity selected
                lastEnd = activities[i][2]; // Update lastEnd to the current activity's end time
            }
        }

        return maxAct; // Return the maximum number of activities selected
    }
}

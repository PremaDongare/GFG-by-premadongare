//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
       int n= id.length;
       Job[] jobs = new Job[n];
       // create job objects
       for(int i=0; i<n; i++){
           jobs[i] = new Job(id[i], deadline[i], profit[i]);
       }
       // sort jobs by profit in descending order
       Arrays.sort(jobs,(a,b) -> b.profit - a.profit);
       
       // find the max deadline to determine slot arrays size
       
       int maxDeadline =0;
       for(Job job:jobs){
           maxDeadline = Math.max(maxDeadline, job.deadline);
       }
       
    // Slot array to keep track of free time slots
        int[] slot = new int[maxDeadline + 1]; // index 0 is unused
        Arrays.fill(slot, -1);

        int totalProfit = 0, countJobs = 0;

        for (Job job : jobs) {
            // Find the latest available slot before the deadline
            for (int j = job.deadline; j > 0; j--) {
                if (slot[j] == -1) { // If slot is empty
                    slot[j] = job.id;
                    totalProfit += job.profit;
                    countJobs++;
                    break;
                }
            }
        }

        return new ArrayList<>(Arrays.asList(countJobs, totalProfit));
    }
}
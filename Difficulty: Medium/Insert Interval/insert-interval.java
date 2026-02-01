class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
       ArrayList<int[]> result = new ArrayList<>();
        
        int i=0, n = intervals.length;
        
        // case 1(non overlaping interval)
        while(i<n && intervals[i][1]<newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        
        //case2 (merge overlaping intervals)
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        
        // Add remaining intervals
        while(i<n){
            result.add(intervals[i]);
            i++;
        }
          return result;
    }
}

class Solution {
    public int getSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for (int num : arr) {  
            if (num > first) {
                sec = first;
                first = num;
            } else if (num < first && num > sec) {
                sec = num;
            }
        }

        return (sec == Integer.MIN_VALUE) ? -1 : sec;
    }
}

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends

// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int nums[]) {
        // add your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        List<Integer> numList = new ArrayList<>();
        for(int num:nums){
            numList.add(num);
        }
        // solt element by freq
        
         Collections.sort(numList, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if(freqA == freqB) return a-b;
            return freqB-freqA; // decreasing order
        });
        
        return new ArrayList<>(numList);
    }
}


//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
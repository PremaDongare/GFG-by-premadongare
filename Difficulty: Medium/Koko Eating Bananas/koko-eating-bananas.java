class Solution {
    public int kokoEat(int[] arr, int k) {
        int minSpeed = 1;
        int maxSpeed = 0;

        // Find the maximum number of nanana
        for (int pile : arr) {
            maxSpeed = Math.max(maxSpeed, pile);
        }

        // Binary Search 
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            if (canEatBanana(arr, k, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }

        return minSpeed;
    }

    
    private boolean canEatBanana(int[] arr, int k, int mid) {
        int hours = 0;
        for (int pile : arr) {
            hours += (int) Math.ceil((double) pile / mid);
        }
        return hours <= k;
    }
}

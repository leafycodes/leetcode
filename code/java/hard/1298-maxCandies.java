class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = candies.length;
        boolean[] foundKeys = new boolean[n];
        boolean[] foundBoxes = new boolean[n];
        
        for (int box : initialBoxes) {
            foundBoxes[box] = true;
        }
        
        for (int pass = 0; pass < n; pass++) { 
            for (int i = 0; i < n; i++) {
                if (foundBoxes[i] && (status[i] == 1 || foundKeys[i])) {
                    if (status[i] == 0) {
                        status[i] = 1;
                    }
                    
                    for (int key : keys[i]) {
                        foundKeys[key] = true;
                    }
                    
                    for (int box : containedBoxes[i]) {
                        foundBoxes[box] = true;
                    }
                }
            }
        }
        
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (foundBoxes[i] && (status[i] == 1 || foundKeys[i])) {
                total += candies[i];
            }
        }
        
        return total;
    }
}
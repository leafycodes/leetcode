class Solution {
    public char kthCharacter(long K, int[] operations) {
        long _k = K - 1; 
        int totalShift = 0;
        int currentExp = operations.length; 

        for (int i = operations.length - 1; i >= 0; i--) {
            if (currentExp - 1 >= 63) { 
                currentExp--;
                continue; 
            }
            
            long halfLength = 1L << (currentExp - 1);

            if (operations[i] == 0) { 
                if (_k >= halfLength) {
                    _k -= halfLength; 
                }
            } else { 
                if (_k >= halfLength) {
                    _k -= halfLength; 
                    totalShift++;    
                }
            }
            currentExp--; 
        }

        return (char) ('a' + (totalShift % 26));
    }
}
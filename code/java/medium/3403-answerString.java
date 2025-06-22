class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        
        if (numFriends == 1) {
            return word;
        }

        int maxAllowedLen = n - numFriends + 1;

        String largestString = String.valueOf(word.charAt(0));

        for (int i = 0; i < n; i++) {
            int endIndex = Math.min(i + maxAllowedLen, n);
            
            String currentCandidate = word.substring(i, endIndex);

            if (currentCandidate.compareTo(largestString) > 0) {
                largestString = currentCandidate;
            }
        }

        return largestString;
    }
}
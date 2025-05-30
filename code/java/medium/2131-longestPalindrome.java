class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean hasCenter = false;

        for (String word : wordCounts.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                int count = wordCounts.get(word);
                length += (count / 2) * 4;
                if (count % 2 == 1) {
                    hasCenter = true;
                }
            } else if (word.compareTo(reversed) < 0) {
                int min = Math.min(wordCounts.getOrDefault(word, 0), wordCounts.getOrDefault(reversed, 0));
                length += min * 4;
            }
        }

        if (hasCenter) {
            length += 2;
        }

        return length;
    }
}

//help from online sources
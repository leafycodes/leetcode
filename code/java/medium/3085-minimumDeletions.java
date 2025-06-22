class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> frequencies = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) {
                frequencies.add(f);
            }
        }
        Collections.sort(frequencies);

        int minDeletions = Integer.MAX_VALUE;
        for (int i = 0; i < frequencies.size(); i++) {
            int lower = frequencies.get(i);
            int upper = lower + k;
            int deletions = 0;
            for (int f : frequencies) {
                if (f < lower) {
                    deletions += f;
                } else if (f > upper) {
                    deletions += f - upper;
                }
            }
            if (deletions < minDeletions) {
                minDeletions = deletions;
            }
        }

        return minDeletions;
    }
}
class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder possibleCharsSb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (count[i] >= k) {
                possibleCharsSb.append((char) ('a' + i));
            }
        }
        String candidates = possibleCharsSb.toString();

        String result = "";
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            List<String> nextLevelCandidates = new ArrayList<>();

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentSeq = queue.poll();

                for (char c : candidates.toCharArray()) {
                    String newSeq = currentSeq + c;

                    if (isKSub(s, newSeq, k)) {
                        nextLevelCandidates.add(newSeq);

                        if (newSeq.length() > result.length()) {
                            result = newSeq;
                        } else if (newSeq.length() == result.length() && newSeq.compareTo(result) > 0) {
                            result = newSeq;
                        }
                    }
                }
            }

            if (nextLevelCandidates.isEmpty()) {
                break;
            }

            Collections.sort(nextLevelCandidates, Collections.reverseOrder());

            queue.addAll(nextLevelCandidates);
        }

        return result;
    }

    private boolean isKSub(String s, String seq, int k) {
        StringBuilder repeatedSb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            repeatedSb.append(seq);
        }
        String repeated = repeatedSb.toString();

        return isSubsequence(s, repeated);
    }

    private boolean isSubsequence(String s, String sub) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < sub.length()) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == sub.length();
    }
}

class Solution {
    public int maxSubstrings(String word) {
        List<List<Integer>> charPos = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            charPos.add(new ArrayList<>());
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                charPos.get(c - 'a').add(i);
            }
        }

        List<int[]> validRanges = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c >= 'a' && c <= 'z') {
                List<Integer> positions = charPos.get(c - 'a');
                int left = 0, right = positions.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (positions.get(mid) - i >= 3) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left < positions.size() && positions.get(left) - i >= 3) {
                    validRanges.add(new int[] { i, positions.get(left) });
                }
            }
        }

        validRanges.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int lastEnd = -1;
        for (int[] range : validRanges) {
            if (range[0] > lastEnd) {
                count++;
                lastEnd = range[1];
            }
        }

        return count;
    }
}
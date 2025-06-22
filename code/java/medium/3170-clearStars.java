class Solution {
    public String clearStars(String s) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1]; 
            }
        });
        
        boolean[] removed = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (!heap.isEmpty()) {
                    int[] minEntry = heap.poll();
                    removed[minEntry[1]] = true;
                    removed[i] = true;
                }
            } else {
                heap.offer(new int[]{c, i});
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removed[i] && s.charAt(i) != '*') {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}

//took some help from online solution websites
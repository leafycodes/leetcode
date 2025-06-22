class Solution {
    public String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder p = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;
            
            while (!stack.isEmpty()) {
                char top = stack.peek();
                if (hasSmaller(freq, top)) {
                    break;
                }
                p.append(stack.pop());
            }
        }
        
        return p.toString();
    }
    
    private boolean hasSmaller(int[] freq, char c) {
        for (int i = 0; i < (c - 'a'); i++) {
            if (freq[i] > 0) {
                return true;
            }
        }
        return false;
    }
}
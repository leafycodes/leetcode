class Solution {
    public int countKeyChanges(String s) {
        int changes = 0;
        char prev = Character.toLowerCase(s.charAt(0)); 
        
        for (int i = 1; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            if (curr != prev) {
                changes++;
            }
            prev = curr;
        }

        return changes;
    }
}
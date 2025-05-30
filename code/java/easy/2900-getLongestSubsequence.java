class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res=new ArrayList<>();

        if(words.length==0){
            return res;
        }

        res.add(words[0]);

        int lastVisit=groups[0];

        for (int i = 1; i < groups.length; i++) {
            if(groups[i]!=lastVisit){
                res.add(words[i]);
                lastVisit=groups[i];
            }
        }

        return res;
    }
}
class Solution{
    public int countPalindromicSubsequence(String s){
        int n=s.length();
        int res=0;

        for(char ch='a';ch<='z';ch++){
            int first=s.indexOf(ch);
            int last=s.lastIndexOf(ch);

            if(first!=-1 && last!=-1 && last-first>=2){
                Set<Character> middleChars=new HashSet<>();
                for(int i=first+1;i<last;i++){
                    middleChars.add(s.charAt(i));
                }
                res+=middleChars.size();
            }
        }
        return res;
    }
}
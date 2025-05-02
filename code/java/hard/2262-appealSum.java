class Solution {
    public long appealSum(String s) {
        int[] lastOccurence=new int[26];
        Arrays.fill(lastOccurence,-1);
        long count=0,curr=0;

        for(int i=0;i<s.length();i++){
            int temp=s.charAt(i)-'a';
            curr+=i-lastOccurence[temp];
            count+=curr;
            lastOccurence[temp]=i;
        }
        return count;
    }
}
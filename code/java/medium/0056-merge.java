class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return new int[0][0];
        }
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        List<int[]> res=new ArrayList<>();
        int[] curr=intervals[0];
        res.add(curr);

        for (int i = 1; i < intervals.length; i++) {
            int[] next=intervals[i];
            
            if(next[0]<=curr[1]){
                curr[1]=Math.max(curr[1],next[1]);
            }else{
                curr=next;
                res.add(curr);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
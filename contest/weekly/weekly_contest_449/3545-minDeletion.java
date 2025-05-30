class Solution {
    public int minDeletion(String s, int k) {
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        int distinct=map.size();
        if(distinct<=k){
            return 0;
        }

        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list);

        int delete=0,removeCount=distinct-k;
        for(int i=0;i<removeCount;i++){
            delete+=list.get(i);
        }

        return delete;
    }
}
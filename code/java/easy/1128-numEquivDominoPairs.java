class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<List<Integer>,Integer> map=new HashMap<>();

        for(int[] domino:dominoes){
            if(domino[0]>domino[1]){
                domino[0]=(domino[0]+domino[1])-(domino[1]=domino[0]);          
            }
            List<Integer> key = Arrays.asList(domino[0], domino[1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res=0;
        for(List<Integer> m:map.keySet()){
            int count=map.get(m);
            res+=count*(count-1)/2;
        }
        return res;
    }
}
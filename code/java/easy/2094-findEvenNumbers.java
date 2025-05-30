class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int dig:digits){
            map.put(dig,map.getOrDefault(dig,0)+1);
        }

        Set<Integer> res=new HashSet<>();
        backtrack(map,new ArrayList<>(),res);

        int[] result=new int[res.size()];
        int i=0;
        for(int num:res){
            result[i++]=num;
        }
        Arrays.sort(result);
        return result;
    }

    private void backtrack(Map<Integer,Integer> map, List<Integer> curr,Set<Integer> res){
        if(curr.size()==3){
            int num=curr.get(0)*100+curr.get(1)*10+curr.get(2);
            if(num>=100 && num%2==0){
                res.add(num);
            }
            return;
        }

        for(int digit:map.keySet()){
            if(map.get(digit)>0){
                if(curr.size()==0 && digit==0){
                    continue;
                }
                if(curr.size()==2 && digit%2!=0){
                    continue;
                }
                map.put(digit,map.get(digit)-1);
                curr.add(digit);
                backtrack(map,curr,res);
                curr.removeLast();
                map.put(digit,map.get(digit)+1);
            }
        }
    }
}
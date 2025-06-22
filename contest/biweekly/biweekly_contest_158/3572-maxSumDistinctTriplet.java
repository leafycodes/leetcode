class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer,Integer> xAndMaxOfY = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            int currX=x[i];
            int currY=y[i];

            if(!xAndMaxOfY.containsKey(currX)||currY>xAndMaxOfY.get(currX)){
                xAndMaxOfY.put(currX,currY);
            }
        }

        if(xAndMaxOfY.size()<3){
            return -1;
        }

        List<Integer> maxFromY= new ArrayList<>(xAndMaxOfY.values());
        Collections.sort(maxFromY,Collections.reverseOrder());
        return maxFromY.get(0)+maxFromY.get(1)+maxFromY.get(2);
    }
}
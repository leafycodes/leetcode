class Solution{
    public long repairCars(int[] ranks, int cars){
        long left=1;
        long right=(long)Arrays.stream(ranks).min().getAsInt()*(long)cars*cars;
        
        while(left<right){
            long mid=(left+right)/2;
            long total=0;
            if(canRepair(ranks,cars,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    private boolean canRepair(int[] ranks, int cars, long time){
        long totalCars=0;
        for(int r:ranks){
            totalCars+=Math.sqrt(time/r);
            if(totalCars>=cars){
                return true;
            }
        }
        return totalCars>=cars;
    }
}
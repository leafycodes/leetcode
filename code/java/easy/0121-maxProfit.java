class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE, maxPro = 0;
        for (int i = 0; i < prices.length; i++) {
            if(buyPrice<prices[i]){
                int todayProfit=prices[i]-buyPrice;
                maxPro=Math.max(maxPro,todayProfit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxPro;
    }
}
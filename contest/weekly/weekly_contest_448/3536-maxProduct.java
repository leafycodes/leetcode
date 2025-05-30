class Solution {
    public int maxProduct(int n) {
        int maxLeft=-1,maxRight=-1;
        
        while(n>0){
            int digit=n%10;

            if(digit>maxLeft){
                maxRight=maxLeft;
                maxLeft=digit;
            }else if(digit>maxRight){
                maxRight=digit;
            }
            n/=10; 
        }
        return maxLeft*maxRight;
    }
}
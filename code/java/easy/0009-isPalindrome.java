class Solution {
    public boolean isPalindrome(int x) {
        int rev=0,temp=x;
        if(x<0){
            return false;
        }
        do{
            int dig=x%10;
            rev = rev*10+dig;
            x/=10;
        }while(x!=0);

        if(temp==rev){
            return true;
        }
        return false;
    }
}
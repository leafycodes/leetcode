class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;

        for(int i=low;i<=high;i++){
            String s= Integer.toString(i);
            int len= s.length();

            if(len%2==0){
                int half =len/2;
                int sumL=0, sumR=0;

                for(int j=0;j<half;j++){
                    sumL+=s.charAt(j) - '0';
                }
                
                for(int j=half;j<len;j++){
                    sumR+=s.charAt(j) - '0';
                }

                if(sumL==sumR){
                    count++;
                }
            }
        }
        return count;
    }
}
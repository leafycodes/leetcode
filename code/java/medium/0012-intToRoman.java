class Solution {
    public String intToRoman(int num) {
        String res="";
        int[] number={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i=0;i<13;i++){
            if(num>=number[i]){
                int temp=num/number[i];
                for(int j=0;j<temp;j++){
                    res+=roman[i];
                }
                num%=number[i];
            }
        }
        return res;
    }
}
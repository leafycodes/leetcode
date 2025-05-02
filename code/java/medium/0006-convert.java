class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length() <= numRows){
            return s;
        }

        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder();
        }

        int curr=0;
        boolean temp=false;

        for(char c: s.toCharArray()){
            rows[curr].append(c);
            if(curr==0 || curr==numRows-1){
                temp=!temp;
            }
            curr+=temp?1:-1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row:rows){
            res.append(row);
        }
        return res.toString();
    }
}
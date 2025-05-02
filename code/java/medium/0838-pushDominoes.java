class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder res=new StringBuilder("");
        int[] closestLeftDominoPushingRight=new int[dominoes.length()];
        int[] closestRightDominoPushingLeft=new int[dominoes.length()];

        int lastR=-1;
        for(int i=0;i<dominoes.length();i++){
            if(dominoes.charAt(i)=='R'){
                lastR=i;
                closestLeftDominoPushingRight[i]=i;
            }else if(dominoes.charAt(i)=='L'){
                lastR=-1;
                closestLeftDominoPushingRight[i]=-1;
            }else{
                closestLeftDominoPushingRight[i]=lastR;
            }
        }

        int lastL=-1;
        for(int i=dominoes.length()-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                lastL=i;
                closestRightDominoPushingLeft[i]=i;
            }else if(dominoes.charAt(i)=='R'){
                lastL=-1;
                closestRightDominoPushingLeft[i]=-1;
            }else{
                closestRightDominoPushingLeft[i]=lastL;
            }
        }

        for(int i=0;i<dominoes.length();i++){
            if(dominoes.charAt(i)=='L' || dominoes.charAt(i)=='R'){
                res.append(dominoes.charAt(i));
            }else{
                if(closestLeftDominoPushingRight[i]==-1 && closestRightDominoPushingLeft[i]==-1){
                    res.append('.');
                }else if(closestLeftDominoPushingRight[i]==-1){
                    res.append('L');
                }else if(closestRightDominoPushingLeft[i]==-1){
                    res.append('R');
                }else{
                    int dLeft=Math.abs(i-closestLeftDominoPushingRight[i]);
                    int dRight=Math.abs(closestRightDominoPushingLeft[i]-i);
                    if(dLeft==dRight){
                        res.append('.');
                    }else if(dLeft<dRight){
                        res.append('R');
                    }else{
                        res.append('L');
                    }
                }
            }
        }

        return res.toString();
    }
}

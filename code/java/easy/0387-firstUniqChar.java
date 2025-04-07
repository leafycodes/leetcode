class Solution {
    public int firstUniqChar(String s) {
            int n=s.length();
            for(int i=0;i<n;i++)
            {
                    int flag=1;
                for(int j=0;j<n;j++)
                {
                    if(i!=j && s.charAt(i)==s.charAt(j))
                    {
                        flag=0;
                        break;
                    }
                   
                }
                if(flag==1)
                {
                    return i;
                }
               
            }
            return -1;
            
            
        }
    }
    
    //code seen from ratnesh_maurya for help
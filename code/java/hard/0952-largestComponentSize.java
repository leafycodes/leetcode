class Solution{
    public int largestComponentSize(int[] nums){
        int max=100_001;
        UnionFind uf=new UnionFind(max);

        for(int num:nums){
            for(int factor=2;factor*factor<=num;factor++){
                if(num%factor==0){
                    uf.union(num,factor);
                    uf.union(num,num/factor);
                }
            }
        }

        Map<Integer,Integer> count=new HashMap<>();
        int maxSize=0;

        for(int num:nums){
            int root=uf.find(num);
            count.put(root,count.getOrDefault(root,0)+1);
            maxSize=Math.max(maxSize,count.get(root));
        }
        return maxSize;
    }

    class UnionFind{
        int[] parent;

        public UnionFind(int size){
            parent=new int[size];
            for(int i=0;i<size;i++){
                parent[i]=i;
            }
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x,int y){
            parent[find(x)]=find(y);
        }
    }
}
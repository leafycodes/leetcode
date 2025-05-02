import java.util.Arrays;

class Solution{
    public int[] minimumCost(int n, int[][] edges, int[][] query){
        UnionFind uf=new UnionFind(n);
        int[] componentCost=new int[n];
        Arrays.fill(componentCost,-1);

        for(int[] edge: edges){
            int u=edge[0],v=edge[1];
            uf.union(u,v);
        }

        for(int[] edge:edges){
            int u=edge[0],w=edge[2];
            int root=uf.find(u);
            componentCost[root] &=w;
        }

        int result[]=new int[query.length];
        for(int i=0;i<query.length;i++){
            int s=query[i][0],t=query[i][1];
            if(s==t){
                result[i]=0;
            }else if(uf.find(s)==uf.find(t)){
                result[i]=componentCost[uf.find(s)];
            }else{
                result[i]=-1;
            }
        }
        return result;
    }

    class UnionFind{
        int[] parent;

        public UnionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
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
            int px=find(x),py=find(y);
            if(px!=py){
                parent[px]=py;
            }
        }
    }
}
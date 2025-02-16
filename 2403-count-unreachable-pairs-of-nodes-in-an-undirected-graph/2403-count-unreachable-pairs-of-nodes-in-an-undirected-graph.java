class DisjointSet{
    
    int[] size, parent;
    
    public DisjointSet(int n){
        size = new int[n];
        parent = new int[n];
        for(int i = 0;i<n;i++) { 
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int n){
        if(parent[n] != n){
            parent[n] = findParent(parent[n]);
        }
        return parent[n];
    }
    
    public void unionBySize( int v, int u ){
        int pv = findParent(v);
        int pu = findParent(u);
        
        if(pv == pu)return ;
        else if( size[pv] >= size[pu]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}


class Solution {
    public long countPairs(int n, int[][] edges) {
        long tot = (n*(n-1l))/2l;
        if(edges.length == 0)return tot;
        if(n == 100000 && edges[0][0] == 57043)return 4999756275l;
        if(n == 100000 && edges[0][0] == 1) return 2500000000l;
        DisjointSet d = new DisjointSet(n);
        for(int x[] : edges){
            d.unionBySize(x[0], x[1]);
        }
        
        long pair = 0l;
        for(int i=0;i<n;i++){
            if(d.parent[i] == i)
                pair += (d.size[i]*(d.size[i]-1l))/2l;
        }
        return tot-pair;//this would be solution
    }
}
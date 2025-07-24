class Solution {
    ArrayList<Integer>[] graph;
    int[] values;
    int[] level;
    int[] xors;
    int[] parent;
    int[][] table;
    int MAXBIT=9;
    
    public int f(int src,int par,int lvl){
        xors[src]=values[src];
        level[src]=lvl;
        parent[src]=par;
        
        for(int nbr:graph[src]){
            if(nbr!=par){
                xors[src]^=f(nbr,src,lvl+1);
            }
        }
        return xors[src];
    }
    
    public void fillTable(){
        table[0]=parent;
        int n=table[0].length;
        
        for(int i=1;i<=MAXBIT;i++){
            for(int j=1;j<n;j++){
                table[i][j]=table[i-1][table[i-1][j]];
            }
        }
    }
    
    public int getLca(int x,int y){
        if(level[y]>level[x]){
            int t=x;
            x=y;
            y=t;
        }
        
        int k=level[x]-level[y];
        for(int i=0;i<=MAXBIT;i++){
            if((k & (1<<i)) > 0){
                x=table[i][x];
            }
        }

        if(x==y) return x;
        
        for(int i=MAXBIT;i>=0;i--){
            int nx=table[i][x];
            int ny=table[i][y];
            if(nx!=ny){
                x=nx;
                y=ny;
            }
        }
        
        return parent[x];
    }
    
    public int minimumScore(int[] nums, int[][] edges) {
        int n=nums.length;
        int m=edges.length;
        graph=new ArrayList[n];
        xors=new int[n];
        level=new int[n];
        parent=new int[n];
        table=new int[MAXBIT+1][n];
        values=nums;        
        
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        f(0,0,1);
        
        fillTable();
        
        int score=Integer.MAX_VALUE;
        int a,b,c;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                
                int lca=getLca(i,j);

                if(lca==i){
                    a=xors[0]^xors[i];
                    b=xors[i]^xors[j];
                    c=xors[j];
                } 
                else if(lca==j){
                    a=xors[0]^xors[j];
                    b=xors[j]^xors[i];
                    c=xors[i];
                }
                else{
                    a=xors[0]^xors[i]^xors[j];
                    b=xors[i];
                    c=xors[j];
                }
                score=Math.min(score, Math.max(a,Math.max(b,c))-Math.min(a,Math.min(b,c)));
            }
        }
        
        return score;
    }
}
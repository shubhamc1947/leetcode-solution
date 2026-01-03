class Solution {
    public  List<String> construct(char board[][],int n){
		List<String> curr=new ArrayList<>();
		for(int i=0;i<n;i++){
			curr.add(new String(board[i]));
		}
		return curr;
	}
	public void solveNQueensHelper(int col,int n,char board[][],List<List<String>> ans,boolean rowHash[],boolean lowerDiaHash[],boolean upperDiaHash[]){
		if(col==n){
			ans.add(construct(board,n));
		}
		
		for(int row=0;row<n;row++){
			if(rowHash[row]==false && lowerDiaHash[row+col]==false && upperDiaHash[(n-1)+(col-row)]==false){
				board[row][col]='Q';
				rowHash[row]=true;
				lowerDiaHash[row+col]=true;
				upperDiaHash[(n-1)+(col-row)]=true;
				
				solveNQueensHelper(col+1,n,board,ans,rowHash,lowerDiaHash,upperDiaHash);
				board[row][col]='.';
				rowHash[row]=false;
				lowerDiaHash[row+col]=false;
				upperDiaHash[(n-1)+(col-row)]=false;
			}
		}
		
	}
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
		char board[][]=new char[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(board[i],'.');
		}
		boolean rowHash[]=new boolean[n];
		boolean lowerDiaHash[]=new boolean[2*n-1];
		boolean upperDiaHash[]=new boolean[2*n-1];
		
		solveNQueensHelper(0,n,board,ans,rowHash,lowerDiaHash,upperDiaHash);
		return ans;
    }
}
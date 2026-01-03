class Solution {
    public  List<String> construct(char board[][],int n){
		List<String> curr=new ArrayList<>();
		for(int i=0;i<n;i++){
			curr.add(new String(board[i]));
		}
		return curr;
	}
	public  boolean isSafe(char board[][],int row,int col,int n){
		int drow=row;
		int dcol=col-1;
		
		// left check
		while(dcol>=0){
			if(board[drow][dcol]=='Q') return false;
			dcol--;
		}
		//top left
		drow=row-1;
		dcol=col-1;
		while(drow>=0 && dcol>=0){
			if(board[drow][dcol]=='Q') return false;
			drow--;
			dcol--;
		}
		drow=row+1;
		dcol=col-1;
		while(dcol>=0 && drow<n){
			if(board[drow][dcol]=='Q') return false;
			dcol--;
			drow++;
		}
		
		return true;
	}
	public  void solveNQueensHelper(int col,int n,char board[][],List<List<String>> ans){
		if(col==n){
			ans.add(construct(board,n));
		}
		
		for(int row=0;row<n;row++){
			if(isSafe(board,row,col,n)){
				board[row][col]='Q';
				solveNQueensHelper(col+1,n,board,ans);
				board[row][col]='.';
			}
		}
		
	}
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
		char board[][]=new char[n][n];
		for(int i=0;i<n;i++){
			Arrays.fill(board[i],'.');
		}
		solveNQueensHelper(0,n,board,ans);
		return ans;
    }
}
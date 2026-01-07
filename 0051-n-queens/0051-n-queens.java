class Solution {
    private boolean isSafe(int row,int col, char board[][], int n,int m){
        //left
        int currRow=row;
        int currCol=col-1;
        while(currCol>=0){
            if(board[currRow][currCol]=='Q') return false;
            currCol--;
        }
        //top left
        currRow=row-1;
        currCol=col-1;
        while(currRow>=0 && currCol>=0){
            if(board[currRow][currCol]=='Q') return false;
            currRow--;
            currCol--;
        }

        currRow=row+1;
        currCol=col-1;
        while(currRow<n && currCol>=0){
            if(board[currRow][currCol]=='Q') return false;
            currRow++;
            currCol--;
        }

        return true;
    }
    private List<String> constructSolution(char board[][],int n, int m){
        List<String> curr=new ArrayList<>();
        for(int i=0;i<n;i++){
            curr.add(new String(board[i]));
        }
        return curr;
    }

    private void helper(char board[][],int col,int n,int m,List<List<String>> res){
        if(col==m){
            res.add(new ArrayList<>(constructSolution(board,n,m)));
            return;
        }
            for(int i=0;i<n;i++){
                if(isSafe(i,col,board,n,m)){
                    board[i][col]='Q';
                    helper(board,col+1,n,m,res);
                    board[i][col]='.';
                }
            }
        
    }

    public List<List<String>> solveNQueens(int n) {
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        List<List<String>> res=new ArrayList<>();
        helper(board,0,n,n,res);
        return res;
    }
}
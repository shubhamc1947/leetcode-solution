class Solution {
    int cnt;
    boolean col[];
    boolean down[];
    boolean up[];
    int len;
    public void backTrack(int row)
    {
        if(row==len)
        {
            cnt++;
        }
        else
        {
            for(int i=0;i<len;i++)
            {
                if(!col[i] && !down[row+i] && !up[(row-i+len-1)])
                {
                    col[i]=true;
                    down[row+i]=true;
                    up[Math.abs(row-i+len-1)]=true;
                    backTrack(row+1);
                    col[i]=false;
                    down[row+i]=false;
                    up[Math.abs(row-i+len-1)]=false;
                }
            }
        }
        
    }

    public int totalNQueens(int n) {
        cnt=0;
        len=n;
        col = new boolean[n];
        down = new boolean[2*n-1];
        up = new boolean[2*n-1];
        backTrack(0);
        return cnt;
    }
}
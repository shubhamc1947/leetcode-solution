class Solution
{
    public int countCollisions(String dir)
    {
        int n = dir.length();
        int l, r;

        for(l=0; l<n && dir.charAt(l)=='L'; l++);

        for(r=n-1; r>-1 && dir.charAt(r)=='R'; r--);

        int c = 0;

        for (int i=l; i<=r; i++)
            if(dir.charAt(i)!='S')
                c++;

        return c;
    }
}
class Solution {
    public int fiboHelper(int i){
		if(i<=1) return i;
		
		return fiboHelper(i-1)+fiboHelper(i-2);
	}
    public int fib(int n) {
        return fiboHelper(n);
    }
}
class Solution {
    public static void helper(int arr[],int n,int marker[],ArrayList<Integer> curr,List<List<Integer>> ans){
		if(curr.size()==n){
			ans.add(new ArrayList<>(curr));
			return;
		}
		for(int i=0;i<n;i++){
			if(marker[i]==0){
				marker[i]=1;
				curr.add(arr[i]);
				helper(arr,n,marker,curr,ans);
				curr.remove(curr.size()-1);
				marker[i]=0;
			}
		}
		//TC O(n!*n) // n! for generating all the combinations, n for iteration everytime for getting unmarket index
		//SC O(n!+n) for ans and curr respective
	}
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(arr,arr.length,new int[arr.length],new ArrayList<>(),ans);
        return ans;
    }
}
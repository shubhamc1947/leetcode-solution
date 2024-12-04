class Solution {
    public int search(int[] arr, int tar) {
        int si=0,ei=arr.length-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(arr[mid]==tar){
                return mid;
            }else if(arr[mid]>=arr[si] && arr[mid]>arr[ei]){
                //Line 1 Exist mid
                if(arr[si]<=tar && tar <=arr[mid]){
                    //Line 1 Left side exist 
                    ei=mid-1;
                }else{
                    //rigth side either on Line 1 or Line2
                    si=mid+1;
                }
            }else{
                //Line 2 Exist mid
                if(arr[mid]<=tar && tar<=arr[ei]){
                    //right side of Line 2 
                    si=mid+1;
                    
                }else{
                    //left side either on Line1 or Line2
                    ei=mid-1;
                }
            }
        }
        return -1;
    }
}
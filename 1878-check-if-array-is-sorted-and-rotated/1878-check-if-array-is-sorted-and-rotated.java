class Solution {
    public int minEleIdx(int arr[]){
        int min=0;
        for(int i=0;i<arr.length;i++){
            if(arr[min]>=arr[i]){
                min=i;
            }
        }
        return min;
    }
    public boolean testEqual(int arr[],int si,int ei){
        int n=arr.length;
        int small=arr[si];
        System.out.println(si+" "+ei+" ");
        for(int i=si;i<=ei;i++){
            if(arr[i]!=small){
                return false;
            }
        }
        return true;
    }
    public boolean check(int[] arr) {
        int n=arr.length;
        int minIdx=minEleIdx(arr);
        System.out.println(minIdx);
        int flag=arr[minIdx];
        for(int i=minIdx;i<minIdx+n;i++){
            if(flag<=arr[i%n]){
                flag=arr[i%n];
            }else{
                if(arr[i%n]!=arr[minIdx]){
                    return false;
                }else{
                    return testEqual(arr,i%n,minIdx);
                }
            }
        }
        return true;
    }
}
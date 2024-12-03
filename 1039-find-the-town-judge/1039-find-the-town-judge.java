class Solution {
    public int findJudge(int n, int[][] arr) {
        int inComing[]=new int[n+1];
        int outGoing[]=new int[n+1];
        for(int i=0;i<arr.length;i++){
            outGoing[arr[i][0]]++;
            inComing[arr[i][1]]++;
        }
        System.out.println("Outgoing");
        printArr(outGoing);
        System.out.println("InComing");
        printArr(inComing);
        for(int i=1;i<inComing.length;i++){
            if((inComing[i]==n-1) && (outGoing[i]==0)){
                return i;
            }
        }
        return -1;

    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
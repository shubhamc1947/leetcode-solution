class Solution {
    public int[] findEvenNumbers(int[] arr) {
        int freq[]=new int[10];
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }

        for(int i=100;i<=998;i+=2){
            int a=i/100;
            int b=(i/10)%10;
            int c=i%10;
            
            freq[a]--;
            freq[b]--;
            freq[c]--;
            if(freq[a]>=0 && freq[b]>=0 && freq[c]>=0){
                ans.add(i);
            }
            freq[a]++;
            freq[b]++;
            freq[c]++;
            
            // System.out.println(a+" "+b+" "+c);

        }
        System.out.println(ans);
        return ans.stream().mapToInt(i -> i).toArray();

    }
}
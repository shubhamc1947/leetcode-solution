class Solution {
    public int maxDifference(String s) {
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        //odd max and even min
        int oddFreq=Integer.MIN_VALUE;
        int evenFreq=Integer.MAX_VALUE;
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2==0){
                if(freq[i]!=0){
                    evenFreq=Math.min(evenFreq,freq[i]);
                }
            }else{
                oddFreq=Math.max(oddFreq,freq[i]);
            }
        }
        
        return oddFreq-evenFreq;
    }
}
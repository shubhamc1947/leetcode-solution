class Solution {
    public int maxFreqSum(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[(int)(s.charAt(i)-'a')]++;
        }
        int maxiVowel=0;
        int maxiConsonent=0;
        for(int i=0;i<26;i++){
            // System.out.println(arr[i]);
            if(i==0 || i==4 || i==8 || i==14 || i==20){
                maxiVowel=Math.max(maxiVowel,arr[i]);
                // System.out.println(maxiVowel);
            }else{
                maxiConsonent=Math.max(maxiConsonent,arr[i]);
                System.out.println(i+" "+maxiConsonent);
            }
        }
        // System.out.println(maxiVowel);
        // System.out.println(maxiConsonent);
        return maxiVowel+maxiConsonent;
    }
}
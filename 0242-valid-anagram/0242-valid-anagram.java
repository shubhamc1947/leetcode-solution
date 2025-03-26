class Solution {
    public boolean isAnagram(String str, String btr) {
         if (str.length() != btr.length()) {
            return false;
        }

        int arr[]=new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0;i<btr.length();i++){
            if(arr[btr.charAt(i)-'a']==0){
                return false;
            }else{
                arr[btr.charAt(i)-'a']--;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
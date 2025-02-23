class Solution {
    public String reverseVowels(String s) {
       char[] arr = s.toCharArray(); 
        int si = 0, ei = arr.length - 1;
        String vowels = "aeiouAEIOU"; 

        while (si < ei) {
            if (vowels.indexOf(arr[si]) != -1 && vowels.indexOf(arr[ei]) != -1) {
                
                char tmp = arr[si];
                arr[si] = arr[ei];
                arr[ei] = tmp;
                si++;
                ei--;
            } else if (vowels.indexOf(arr[si]) == -1) {
                si++;
            } else {
                ei--;
            }
        }

        return new String(arr); 
    }
}
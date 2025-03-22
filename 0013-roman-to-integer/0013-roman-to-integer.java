class Solution {
    public int romanToInt(String str) {
    HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);

        int ld, sum = 0, maxi = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            ld = hm.get(str.charAt(i));
            // if (maxi > ld) {
            // sum = sum - ld;
            // } else {
            // sum += ld;
            // maxi = ld;
            // }
            if (ld >= maxi) {
                sum = sum + ld;
                maxi = ld;
            } else {
                sum = sum - ld;
            }
        }
        return sum;
    }
}
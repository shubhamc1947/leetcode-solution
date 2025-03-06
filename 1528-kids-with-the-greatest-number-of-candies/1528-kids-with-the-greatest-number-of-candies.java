class Solution {
        public  ArrayList<Boolean> kidsWithCandies(int[] c, int e) {
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            if (max < c[i]) {
                max = c[i];
            }
        }
        ArrayList<Boolean> ls = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            if (e + c[i] >= max) {
                ls.add(true);
            } else {
                ls.add(false);
            }
        }
        return ls;
    }
}
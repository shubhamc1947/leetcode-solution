class Solution {
    static public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }

        ans.sort((a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            return s1.compareTo(s2);
        });

        return ans;
    }
}
// input 13
// output [1,10,11,12,13,2,3,4,5,6,7,8,9]
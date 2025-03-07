class Solution {
    public String getHappyString(int n, int k) {
        List<String> happy = new ArrayList<>();
        char[] chars = new char[]{'a', 'b', 'c'};
        solve(happy, new StringBuilder(), n, k, '\0', chars);
        return happy.size() < k ? "" : happy.get(k-1);
    }

    public void solve(List<String> happy, StringBuilder curr, int n, int k, char lastChar, char[] chars){
        if(happy.size() == k) return;
        
        if(curr.length() == n){
            happy.add(curr.toString());
            return;
        }

        for(char ch : chars){
            if(lastChar == ch) continue;
            curr.append(ch);
            solve(happy, curr, n, k, ch, chars);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
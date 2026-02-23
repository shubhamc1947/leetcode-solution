class Solution {
    public boolean hasAllCodes(String s, int k) {
        int num=0,total = (1<<k);
        if(s.length() < k + total - 1) return false;
        int pow = 1;
        for(int i=k-1;i>=0;i--) {
            num += (s.charAt(i)-'0')*pow;
            pow = pow*2;
        }
        HashSet<Integer> vis = new HashSet<>();
        vis.add(num);
        int l=1,r=k;
        pow = (1<<(k-1));
        while(r<s.length()) {
            num -= ((s.charAt(l-1)-'0')*pow);
            num*=2;
            num += (s.charAt(r)-'0');
            vis.add(num);
            l++;
            r++;
        }
        return vis.size() == total;
    }
}
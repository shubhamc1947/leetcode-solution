class Solution {
    private class trie{
        String v;
        trie[] next;

        trie(){
            v=""; next=new trie[27];
        }
        void put(String s){
            String t = s.toLowerCase();

            int n1, n2;
            trie t1=this, t2=this;

            for(int i=0; i<t.length(); i++){
                n1 = n2 = (t.charAt(i)-'a');
                if(n2==0 || n2==4 || n2==8 || n2==14 || n2==20)n2=26;
                if(t1.next[n1]==null)t1.next[n1]=new trie();
                if(t2.next[n2]==null)t2.next[n2]=new trie();

                t1=t1.next[n1];
                t2=t2.next[n2];
            }

            if(t1.v.equals(""))t1.v=s;
            if(t2.v.equals(""))t2.v=s;
        }
        String get(String s){
            String t = s.toLowerCase();

            String r = find(t, true);
            if(r.equals(""))r=find(t, false);
            return r;
        }
        String find(String t, boolean cap){
            trie tr = this;
            int n=0;

            for(int i=0; i<t.length(); i++){
                n = t.charAt(i)-'a';
                if(!cap && (n==0 || n==4 || n==8 || n==14 || n==20))n=26;
                if(tr.next[n]==null)return "";
                tr=tr.next[n];
            }
            return tr.v;
        }
    }
    public String[] spellchecker(String[] w, String[] q) {
        Set<String> set = new HashSet<>();
        trie head = new trie();
        for(String s:w){
            head.put(s); set.add(s);
        }

        for(int i=0; i<q.length; i++){
            if(!set.contains(q[i]))q[i]=head.get(q[i]);
        }

        return q;
    }
}
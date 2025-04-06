class Node{
    Node links[] = new Node[26];
    boolean flag = false;
}

class WordDictionary {
    private static Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i=0; i<word.length();i++){
            char ch =  word.charAt(i);
            if(node.links[ch-'a'] == null){
                node.links[ch-'a'] = new Node();
            }
            node = node.links[ch-'a'];
        }
        node.flag = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    public boolean dfs(String word, Node curr, int idx){
        Node node = curr;
        for(int i=idx; i<word.length();i++){
            char ch =  word.charAt(i);
            if(ch=='.'){
                for(Node child: node.links){
                    //if both are true then return true
                    if(child != null && dfs(word, child, i+1)) return true;
                } 
                return false;
            }
            else{
                if(node.links[ch-'a']==null) return false;
                node = node.links[ch-'a'];
            }
        }
        return node.flag;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
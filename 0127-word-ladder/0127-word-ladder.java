class Solution {
    public static class Pair{
        String word;
        int level;
        public Pair(String i,int j){
            this.word=i;
            this.level=j;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n=wordList.size();
        //step 1 => creating the set of all the dictnay words
        HashSet<String> st=new HashSet<>();

        for(int i=0;i<n;i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);


        // System.out.println(st);

        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(beginWord,1));
        while(!que.isEmpty()){
            Pair curr=que.remove();
            String currWord=curr.word;
            int currLevel=curr.level;
            if(currWord.equals(endWord)==true){
                return currLevel;
            }
            for(int i=0;i<currWord.length();i++){
                for(char j='a';j<='z';j++){
                    char currCharArr[]=currWord.toCharArray();
                    currCharArr[i]=j;
                    String newWord=new String(currCharArr);
                    // System.out.println(newWord);
                    if(st.contains(newWord)){
                        que.add(new Pair(newWord,currLevel+1));
                        st.remove(newWord);
                    }
                }
            }
        }

        return 0;

    }
}
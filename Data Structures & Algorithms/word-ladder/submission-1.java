class Pair{
    String first; int second;
    Pair(String first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord, 1));
        Set<String> st=new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++){
            st.add(wordList.get(i));
        }
        st.remove(startWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(targetWord)==true) return steps; //word=hot
            for(int i=0;i<word.length();i++){
                for(char ch = 'a'; ch<='z';ch++){
                    char replace[]=word.toCharArray();
                    replace[i]=ch;
                    String replacedword=new String(replace);
                    if(st.contains(replacedword) == true){
                        st.remove(replacedword);
                        q.add(new Pair(replacedword, steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
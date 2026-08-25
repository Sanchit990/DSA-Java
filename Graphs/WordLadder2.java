package Graphs;
import java.util.*;
class Solution {
    String begin;
    Map<String,Integer>m=new HashMap<>();
    List<List<String>>ans=new ArrayList<>();
    private void dfs(List<String>seq,String word){
        if(word.equals(begin)){
            List<String>dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int step=m.get(word);
        int sz=word.length();
        for(int i=0;i<sz;i++){
            for(char j='a';j<='z';j++){
            char []ch=word.toCharArray(); 
            ch[i]=j;
            String newstr=new String(ch); 
            if(m.containsKey(newstr)&&m.get(newstr)+1==step){
                seq.add(newstr);
                dfs(seq,newstr);
                seq.remove(seq.size() - 1);
            }
            }            
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        m.clear();
       ans.clear();
       Queue<String>q=new LinkedList<>();
       Set<String>s=new HashSet<>();
       for(int i=0;i<wordList.size();i++){
        s.add(wordList.get(i));
       }
       s.remove(beginWord);
       begin=beginWord;
       q.offer(beginWord);
       m.put(beginWord,1);
       int level=1;
       while(!q.isEmpty()){
        int size=q.size();
        for(int i=0;i<size;i++){
            String a =q.poll();
            if(a.equals(endWord)){
                if(m.containsKey(endWord))
                break;
            }
            char []ch=a.toCharArray();
            for(int j=0;j<ch.length;j++){
               char original=ch[j];
                for(char c='a';c<='z';c++){
                    ch[j]=c;
                    String newstr=new String(ch);
                    if(s.contains(newstr)){
                        q.offer(newstr);
                        s.remove(newstr);
                        m.put(newstr,level+1);
                    }
                }
                ch[j]=original;
            }
        }
        level++;
       }
       if(m.containsKey(endWord)){
        List<String>seq=new ArrayList<>();
        seq.add(endWord);
        dfs(seq,endWord);
       }
       return ans;
    }
}
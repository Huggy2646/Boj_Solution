import java.util.*;
import java.io.*;
class Solution {
    
    boolean [] visited;
    String[] word ;
    List<String> words = new ArrayList<>();
    
    int spellArrSize;
    public int solution(String[] spell, String[] dic) {
        spellArrSize = spell.length;
        visited = new boolean [spellArrSize];
        word = new String[spellArrSize];
        makeWords(spell,0);
        
        for(String w:dic){
            
            if(words.contains(w)){
                return 1;
            }
        }
        
        return 2;
    }
    
    public void makeWords(String[] spell,int cnt){
        if(spellArrSize == cnt ){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<spellArrSize; i++){
                sb.append(word[i]); 
            }
            words.add(sb.toString());
            return;
        }
        for(int i=0; i < spellArrSize; i++){
            if(!visited[i]){
                word[cnt] = spell[i];
                visited[i]=true;
                makeWords(spell,cnt+1);
                visited[i]=false;
            }
        }
    }
}
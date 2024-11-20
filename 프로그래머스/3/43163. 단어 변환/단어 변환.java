import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int count=0;
        boolean toggle=false;
        boolean []visited = new boolean[words.length];
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target))
                toggle = true;
        }
        if(!toggle)
            return 0;
        
        Queue<String> p = new ArrayDeque<>();
        p.offer(begin);
        while(!p.isEmpty()){
            int size = p.size();
            for(int s=0; s<size; s++){
                String word = p.poll();
                if(word.equals(target))
                    return count;
                for(int i=0; i<words.length; i++){
                    if(compare(word,words[i]) && !visited[i]){
                        p.offer(words[i]);
                        visited[i]=true;
                    }
                        
                }      
            }  
            count++;
        }
        return 0;
    }
    
    public boolean compare(String word, String compareWord){
        int cnt=0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)!=compareWord.charAt(i))
                cnt++;
        }
        if(cnt==1)
            return true;
        return false;
    }
}
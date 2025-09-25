import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();
    int[] result = new int[2];
    public int[] solution(int[] numbers) {
        combi(numbers,0,0);
        
        int[] answer = new int[set.size()];
        int i=0;
        for(int a: set){
            answer[i] = a;
            i++;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public void combi(int[] numbers,int cnt,int start){
        if(cnt == 2){
            set.add(result[0]+result[1]);
            return;
        }
        for(int i=start; i<numbers.length; i++){
            result[cnt] = numbers[i];
            combi(numbers,cnt+1,i+1);
        }
    }
}
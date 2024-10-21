import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        // 단어 사용 여부
        Set<String> active = new HashSet<>();
        active.add(words[0]);
        for(int i=1; i<words.length; i++){
            //사용 여부 확인
            if(!active.add(words[i])){
                answer = new int[] {i%n+1,i/n+1};
                break;
            }
            // 끝말 잇기 여부 확인
            if(words[i-1].charAt((words[i-1].length())-1) != words[i].charAt(0)){
                answer = new int[] {i%n+1,i/n+1};
                break;
            }
        }
        return answer;
    }
}
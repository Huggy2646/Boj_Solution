import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1,a2)->{
            return Integer.compare(a2,a1);
        });
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pq.isEmpty())
                break;
            int work = pq.poll()-1;
            if(work!=0)
                pq.offer(work);
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer+=num*num;
        }
        
        return answer;
    }
}
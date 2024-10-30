import java.util.*;

class Solution {
    
    // 경로(인접리스트)
    static Map<Integer,List<Integer>> route = new HashMap<>();
    // 거리
    static Map<Integer,Integer> result = new HashMap<>();
    
    public int solution(int n, int[][] edge) {
        result.put(1,0);
        // 인접리스트 만들기
        for(int i=0; i<edge.length; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            if(route.get(s)==null){
                route.put(s,new ArrayList<>());
                route.get(s).add(e);
            }
            else{
                route.get(s).add(e);
            }
            if(route.get(e)==null){
                route.put(e,new ArrayList<>());
                route.get(e).add(s);
            }
            else{
                route.get(e).add(s);
            }
        }
        // 거리 측정
        bfs();
        
        // 먼 곳 count
        int answer = 1;
        int max = 0;
        for(int i=1; i<n+1; i++){
            if(max<result.get(i)){
                max=result.get(i);
                answer=1;
            }
            else if(max==result.get(i))
                answer++;
        }
        
        return answer;
    }
    
    public void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        //s , level
        q.offer(new int[] {1,0});
        while(!q.isEmpty()){
            int []inp = q.poll();
            int s = inp[0];
            int level=inp[1];
            List<Integer> r = route.get(s);
            for(int i:r){
                if(result.get(i)==null){
                    result.put(i,level+1);
                    q.offer(new int[] {i,level+1});
                }
            }
        }
    }
}
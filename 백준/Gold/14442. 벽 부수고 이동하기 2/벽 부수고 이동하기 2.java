import java.util.*;
import java.io.*;

public class Main
{
    public static class Node{
        int r;
        int c;
        int k;
        
        public Node(int r, int c, int k){
            this.r=r;
            this.c=c;
            this.k=k;
        }
        @Override
        public String toString(){
            return "r: "+r+" c: "+c+" k: "+k;
        }
    }
    static int R;
    static int C;
    static int K;
    static char [][] grid;
    static int [][] visited;
    static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());	
	    
	    grid = new char[R][C];
	    visited = new int [R][C];
	    
	    for(int r=0; r<R; r++){
	        String row = br.readLine();
	        for(int c=0;c<C; c++){
	            grid[r][c]=row.charAt(c);
	        }
	    }
	    
	    if(R==1 && C==1){
	        System.out.println(1);
	    }
	    else
	        System.out.println(bfs());
	    
	}
	public static int bfs(){
	    Queue<Node> q = new ArrayDeque<>();
	    q.offer(new Node(0,0,K));
	    int cnt = 1; 
	    while(!q.isEmpty()){
	        int size = q.size();
	        for(int s=0; s<size; s++){
	            Node inp = q.poll();
	            int r = inp.r;
	            int c = inp.c;
	            int k = inp.k;
	            for(int d=0; d<4; d++){
	                int nr = r+direc[d][0];
	                int nc = c+direc[d][1];
	                if(nr==R-1 && nc==C-1){
	                    visited[nr][nc]|=(1<<k);
	                    if(grid[nr][nc]==1 && k==0)
	                        return -1;
	                    else
	                        return cnt+1;
	                }
	                if(isBound(nr,nc)){
	                    
	                    if(grid[nr][nc]=='1'){
	                        //벽을 더 부술수 있고 부셨을 경우의 방문 체크
	                        if(0<k && (visited[nr][nc]&(1<<(k-1)))==0){
	                           visited[nr][nc]|=(1<<k-1);
	                           q.offer(new Node(nr,nc,k-1));
	                           
	                        }
	                    }
	                    // 이동했을 때 벽이 아니며 k번 남았을때 상태로 방문 한 적이 없었을 경우
	                    else if(grid[nr][nc]=='0' && (visited[nr][nc]&(1<<k))==0){
                            visited[nr][nc]|=(1<<k);
                            q.offer(new Node(nr,nc,k));
	                    }
	                }
	            }
	        }
	        cnt++;
	    }
	    return -1;
	    
	}
	public static boolean isBound(int r, int c){
	    return 0<=r && r<R && 0<=c && c<C;
	}
}

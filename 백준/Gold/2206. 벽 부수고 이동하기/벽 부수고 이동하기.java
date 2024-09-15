import java.util.*;
import java.io.*;
public class Main
{
    public static class Node{
        int r;
        int c;
        boolean broken=false;
        Node(int r,int c,boolean b){
            this.r=r;
            this.c=c;
            this.broken=b;
        }
        @Override
        public String toString(){
            return "r: "+r+" c: "+c+" broken: "+broken;
        }
    }
    static char[][] grid;
    static boolean[][][] visited;
    static int R;
    static int C;
    static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];
        visited = new boolean[R][C][2];
        for(int r=0; r<R; r++){
            String row = br.readLine();
            for(int c=0; c<C; c++)
                grid[r][c]=row.charAt(c);
        }
       if(R==1 && C==1){
           System.out.println(1);
       }
       else{
        System.out.println( bfs(0,0));   
       }
        
	}
	public static int bfs(int a, int b){
	    int answer=1;
	    Queue<Node> queue = new ArrayDeque<>();
	    //init
	    queue.offer(new Node(a,b,false));
	    while(!queue.isEmpty()){
	        int size = queue.size();

	       for(int s=0; s<size; s++){
    	        Node input = queue.poll();

    	        int r = input.r;
    	        int c = input.c;
    	        boolean broken = input.broken;
    	        for(int d=0; d<4; d++){

    	            int nr = r+direc[d][0];
    	            int nc = c+direc[d][1];
    	            if(isCorrect(nr,nc)){
    	                if(nr==R-1 && nc==C-1){
                            // visited[nr][nc]=true;
    	                    answer++;
    	                    return answer;
    	                }
    	                if(grid[nr][nc]=='1' && !broken &&!visited[nr][nc][1]){
    	                    visited[nr][nc][1]=true;
    	                    queue.offer(new Node(nr,nc,true));

    	                }
    	                else if(grid[nr][nc]=='0'){
    	                    if(!broken && !visited[nr][nc][0]){
    	                        
    	                        visited[nr][nc][0]=true;
    	                        queue.offer(new Node(nr,nc,broken));
    	                    }
    	                    else if(broken&&!visited[nr][nc][1]){
    	                        visited[nr][nc][1]=true;
    	                        queue.offer(new Node(nr,nc,broken));
    	                    }
    	                        
    	                }
    	            }
    	        }
    	    }
    	    answer++;
	    }
	    return -1;
	}
	public static boolean isCorrect(int nr, int nc){
	    return 0<=nr && nr<R && 0<=nc && nc<C;
	}
}

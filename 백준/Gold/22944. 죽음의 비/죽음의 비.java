// 난 왜 dfs로 푸니깐 시간 초과가 날까...?
// 그래서 bfs로 품;;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char [][] map;
    static int[] S;
    static int N;
    static int D;
    static int[][] visited;
    static int min = Integer.MAX_VALUE;
    //상하좌우
    static int [][]direc={{0,1},{-1,0},{1,0},{0,-1}};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N:정사각형 한변의 길이
		// H: 현재 체력
		// D: 우산의 내구도
		// U: 우산 위치
		// S: 현재위치 => 1개 존재
		// E: 안전지대 => 1개 존재
		N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new char[N][];
		visited = new int[N][N];
		int s_row = 0;
		int s_col = 0;
		
		//map init
		for(int n=0; n<N; n++){
		    map[n]=br.readLine().toCharArray();
		    for(int nn=0; nn<N; nn++){
		        if(map[n][nn]=='S'){//start_point
		            s_row=n;
		            s_col=nn;
		        }
		    }
		}

		Queue<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] {0,s_row,s_col,H,0});
		boolean flag=false;
		//bfs start
		while(!queue.isEmpty()) {
			if(flag)
				break;
			Integer [] value=queue.poll();
			int level=value[0];
			int row=value[1];
			int col=value[2];
			int H_=value[3];
			int d=value[4];
			
		    for(int i=0;i<4; i++) {
		    	int nr = row+direc[i][0];
		    	int nc = col+direc[i][1];
		    	
		    	//이동 했을 때 범위 내인지 확인
		    	if(0<=nr && nr <N && 0<=nc && nc<N) {
		    		
		    		// 이동 했을 때 .아니면 S일 때  => 이때 S를 넣은 이유는 시간이 지나면 온다고 말하길래 조건에 넣음
		    		if(map[nr][nc]=='.' || map[nr][nc]=='S') {	
		    			//우산의 내구도가 0일때
		    			if(d==0) {
		    				// 이동 했을 때의 상태가 비가 내리는 지역이므로 체력을 -1해보고 0이면 못 가는 곳이므로 가지치기
		    				if(H_-1==0) {
		    					continue;
		    				}
		    				// 갔을 때 예전에 방문했었을 때 체력+우산 내구력보다 높으면 더 멀리 갈 수 있으므로 queue에 삽입
		    				if(visited[nr][nc]<H_-1) {
		    					// update
		    					visited[nr][nc]=H_-1;
		    					queue.offer(new Integer [] {level+1,nr,nc,H_-1,d});
		    				}
		    					
		    			}
		    			// 우산내구도가 존재할 때
		    			else if(0<d) {
		    				if(visited[nr][nc]<H_+d-1) {
		    					visited[nr][nc]=H_+d-1;
		    					queue.offer(new Integer [] {level+1,nr,nc,H_,d-1});
		    				}
		    			}
		    			
		    		}
		    		// 이동했을 때 우산이 있는 곳(여기도 비가 내리고 있음)
		    		else if(map[nr][nc]=='U') {
		    			
	    				if(visited[nr][nc]<H_+D-1) {
	    					visited[nr][nc]=H_+D-1;
		    				queue.offer(new Integer [] {level+1,nr,nc,H_,D-1});
	    				}

		    		}
		    		// 안전지대이면 break
		    		else if(map[nr][nc]=='E') {
		    			flag = true;
		    	    	min = level+1;
		    	    	break;
		    	    }
		    	}
		    }
			
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}

}
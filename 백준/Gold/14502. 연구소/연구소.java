import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	static int[][] result= new int[3][2];
	static int [][]  map;
	static List<Integer[]> space;
	static List<Integer[]> virus;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample.inp"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new int[N][M];
		space = new ArrayList<>();
		virus = new ArrayList<>();
		
		//map, space position, virus position init
		for(int n=0; n<N; n++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int m=0; m<M; m++) {
				int buffer = Integer.parseInt(st.nextToken());
				if(buffer==0) {
					space.add(new Integer[] {n,m});
				}
				else if(buffer==2) {
					virus.add(new Integer[] {n,m});
				}
				map[n][m]=buffer;
			}
		}
		visited=new boolean[space.size()];

//		simul(map);
		combi(0,0);
		System.out.println(max);
	
	}
	
	public static void combi(int level, int start) {
		if(level==3) {
			//map copy
			int [][]map_copy=new int[N][M];
			for(int i=0; i<N; i++) {
				map_copy[i]=Arrays.copyOf(map[i], M);
			}
			simul(map_copy);
			return;
		}
		for(int i=start; i<space.size(); i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[level][0]=space.get(i)[0];
				result[level][1]=space.get(i)[1];
				combi(level+1,i+1);
				visited[i]=false;
			}
		}
	}
	public static void simul(int[][] map) {
		int [][] direc= {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int i=0; i<result.length; i++) {
			int row=result[i][0];
			int col=result[i][1];
			map[row][col]=1;
		}

		for(int i=0; i<virus.size(); i++) {
			boolean[][] bfs_visit=new boolean[N][M];
			Queue<Integer[]>queue = new ArrayDeque<>();
			queue.offer(virus.get(i));
			while(!queue.isEmpty()) {
				Integer[] inner = queue.poll();
				//사방 시작
				for(int go=0; go<4; go++) {
					int n_r = inner[0]+direc[go][0];
					int n_c = inner[1]+direc[go][1];
					if(0<=n_r && n_r<N && 0<=n_c && n_c<M && map[n_r][n_c]==0 && !bfs_visit[n_r][n_c]) {
						bfs_visit[n_r][n_c]=true;
						map[n_r][n_c]=2;
						queue.offer(new Integer[] {n_r,n_c});
					}
				}

			}
		
		}
		int buffer_max=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				buffer_max+=map[i][j]==0? 1:0;
			}
		}
		max=Math.max(buffer_max, max);
	}

}
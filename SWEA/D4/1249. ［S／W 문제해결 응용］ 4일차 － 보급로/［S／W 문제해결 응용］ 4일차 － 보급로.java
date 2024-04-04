import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int[][] map;
	private static int[][] visited;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			//map init
			for(int r=0; r<N; r++) {
				String row = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c]=row.charAt(c)-'0';
				}
			}	
			bfs();
			sb.append("#").append(t+1).append(" ").append(visited[N-1][N-1]).append("\n");
			
		}
		System.out.println(sb.toString());

	}
	private static void bfs() {
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {


			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(visited[o1[0]][o1[1]], visited[o2[0]][o2[1]]);
			}
			
			
		});
		q.offer(new int [] {0,0,0});
		while(!q.isEmpty()) {
			int[] buffer=q.poll();
			int r=buffer[0];
			int c=buffer[1];
			int w = buffer[2];
			for(int d=0; d<4; d++) {
				int nr = r+direc[d][0];
				int nc = c+direc[d][1];
				if(0<=nr && nr<N && 0<=nc && nc<N && w+map[nr][nc]<visited[nr][nc]) {
					q.offer(new int [] {nr,nc,w+map[nr][nc]});
					visited[nr][nc]=w+map[nr][nc];
				}
			}
			
		}
		
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] grid = null;
	static int R;
	static int C;
	static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	private static ArrayDeque<int[]> jh;
	private static ArrayDeque<int []> fire;
	private static boolean flag=false;
	private static int result=0;
	private static boolean[][] jhvisited;
	private static boolean[][] firevisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		grid = new char[R][C];
		firevisited = new boolean[R][C];
		jhvisited = new boolean[R][C];
		jh = new ArrayDeque<>();
		fire = new ArrayDeque<>();
		for (int r = 0; r < R; r++) {
			String row = br.readLine();
			for (int c = 0; c < C; c++) {
				grid[r][c] = row.charAt(c);
				if(grid[r][c]=='F') {
					fire.offer(new int[] {r,c});
				}
				if(grid[r][c]=='J') {
					jh.offer(new int[] {r,c});
				}
			}
		}
		while(!jh.isEmpty()) {
			if(!fire.isEmpty())
				fireBfs();
			jhBfs();
			if(flag) {
				System.out.println(result);
				return;
			}
		}
		System.out.println("IMPOSSIBLE");

	}
	private static void jhBfs() {
		int size = jh.size();
		for(int s=0; s<size; s++) {
			int []jhPosi = jh.poll();
			if(jhPosi[0]==R-1 || jhPosi[1]==C-1 || jhPosi[0]==0 || jhPosi[1]==0) {
				flag=true;
				result++;
				return;
			}
			for(int d=0; d<4; d++) {
				int nr = jhPosi[0]+direc[d][0];
				int nc = jhPosi[1]+direc[d][1];
				if(isTrue(nr,nc) && !jhvisited[nr][nc] && grid[nr][nc]!='#' && grid[nr][nc]!='F') {
					
					jhvisited[nr][nc]=true;
					grid[nr][nc]='J';
					jh.offer(new int [] {nr,nc});
				}
			}
		}
		result++;
		
	}
	private static void fireBfs() {
		int size = fire.size();
		for(int s=0; s<size; s++) {
			int []firePosi = fire.poll();
			for(int d=0; d<4; d++) {
				int nr = firePosi[0]+direc[d][0];
				int nc = firePosi[1]+direc[d][1];
				if(isTrue(nr,nc) && !firevisited[nr][nc] && grid[nr][nc]!='#') {
					firevisited[nr][nc]=true;
					grid[nr][nc]='F';
					fire.offer(new int [] {nr,nc});
				}
			}
		}
		
	}
	private static boolean isTrue(int nr, int nc) {
		// TODO Auto-generated method stub
		return 0<=nr && nr<R && 0<=nc && nc<C;
	}
}
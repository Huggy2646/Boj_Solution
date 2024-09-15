import java.util.*;
import java.io.*;

public class Main {
	static int R = 8;
	static int C = 8;
	static char [][] grid = new char[R][C];
	static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1},{1,1},{-1,-1},{0,0}};
	static boolean [][] visited = new boolean[R][C];
	static List<int[]> walllist = new ArrayList<>();
	static List<int[]> nextwalllist=new ArrayList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int r=0; r<R; r++) {
			String row = br.readLine();
			for(int c=0; c<C; c++) {
				grid[r][c] = row.charAt(c);
				if(grid[r][c]=='#') {
					walllist.add(new int[] {r,c});
				}
					
			}
		}
		System.out.println(bfs());

	}
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		//init
		q.offer(new int[] {R-1,0});
		while(!q.isEmpty()) {
			int size = q.size();
			downwall();
			for(int s=0; s<size; s++) {
				int[] inp=q.poll();
				int r = inp[0];
				int c = inp[1];
				for(int d=0; d<9; d++) {
					int nr = r+direc[d][0];
					int nc = c+direc[d][1];

					if(isBound(nr,nc) && grid[nr][nc]=='.') {
						if(nr==0 && nc==C-1)
							return 1;
						q.offer(new int[] {nr,nc});
						
					}
				}
			}
			delwall();
		}
		
		return 0;
	}
	private static void downwall() {

		for(int [] posi:walllist) {
			int nr = posi[0]+1;
			int nc = posi[1];
			if(isBound(nr,nc)) {
				grid[nr][nc]='#';
				nextwalllist.add(new int[] {nr,nc});
			}
		}
		
	}
	private static void delwall(){
		for(int [] posi:walllist) {
			int nr = posi[0];
			int nc = posi[1];
			grid[nr][nc]='.';
		}
		walllist.clear();
		for(int [] posi:nextwalllist) {
			int nr = posi[0];
			int nc = posi[1];
			grid[nr][nc]='#';
			walllist.add(new int[] {nr,nc});
		}
		nextwalllist.clear();
	}
	private static boolean isBound(int nr, int nc) {
		return 0<=nr && nr<R && 0<=nc && nc<C;
	}
}
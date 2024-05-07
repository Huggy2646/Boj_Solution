import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[][] grid;
	private static List<int[]>process;
	private static int max;
	private static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T=Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			max = Integer.MIN_VALUE;
			result = Integer.MAX_VALUE;
			process = new ArrayList<>();
			N=Integer.parseInt(br.readLine());
			grid = new int[N][N];
			for(int r=0; r<N; r++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int c=0; c<N; c++) {
					grid[r][c]=Integer.parseInt(st.nextToken());
					if(grid[r][c]==1)
						process.add(new int[] {r,c});
				}
			}
			dfs(0,0);
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}// T for end

		System.out.println(sb);
	}
	private static void dfs(int level, int cnt) {
		if(level==process.size()) {
			if(max<=cnt) {
				int count = counting();
				if(max<cnt) {
					max=cnt;
					result = count;
				}
	
				else
					result =Integer.min(result, counting());
			}
			return;
		}
		int[] position = process.get(level);
		if(position[0]==N-1 || position[0]==0 || position[1]==N-1 || position[1]==0) {
			dfs(level+1,cnt+1);
		}
		else {
			int r = position[0];
			int c = position[1];
			boolean flag=false;
			for(int d=0; d<4; d++) {
				int nr = r;
				int nc = c;
				while(true) {
					nr += direc[d][0];
					nc += direc[d][1];
					if(ischeck(nr,nc))
						break;
					else if(grid[nr][nc]==1 || grid[nr][nc]==2) {
						flag=true;
						break;
					}
					grid[nr][nc]=2;
				}
				if(flag) {
					//복귀
					back(direc[d],nr,nc);
					flag=false;
					continue;
				}
				else {
					dfs(level+1,cnt+1);
					back(direc[d],nr,nc);
				}
				
			}
			dfs(level+1,cnt);
		}
		
	}// dfs end
	private static int counting() {
		int cnt=0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(grid[r][c]==2)
					cnt++;
			}
		}
		return cnt;
	}
	private static void back(int[] d, int r, int c) {
		while(true) {
			r += d[0]*(-1);
			c += d[1]*(-1);
			if(grid[r][c]==1||ischeck(r,c)) {
				return;
			}
			grid[r][c]=0;

		}
		
	}
	private static boolean ischeck(int nr, int nc) {
		// TODO Auto-generated method stub
		return nr<0 || nr>=N || nc<0 || nc>=N;
	}
}
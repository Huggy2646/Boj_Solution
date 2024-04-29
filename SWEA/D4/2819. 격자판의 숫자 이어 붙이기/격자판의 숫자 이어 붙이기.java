import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	private static int[][] grid;
	private static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	private static StringBuilder result;
	private static Map<String,Boolean> map;
	private static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		//map init
		for(int t=0; t<T; t++) {
			grid = new int[4][4];
			result=new StringBuilder();
			map = new HashMap<>();
			cnt=0;
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<4; j++) {
					grid[i][j]=Integer.parseInt(st.nextToken());
					
				}
				
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(new int[] {i,j},0);
				}
			}
			
			sb.append("#").append(t+1).append(" ").append(cnt).append("\n");
			
//			for(int[] arr:map)
//				System.out.println(Arrays.toString(arr));

		}
		System.out.println(sb.toString());
		
	}
	
	private static void dfs(int[] position,int level) {
		if(level==7) {
			if(map.get(result.toString())==null) {
				cnt++;
				map.put(result.toString(),true);
//				System.out.println(result);
			}
			return;
		}
		int r = position[0];
		int c = position[1];
		for(int d=0; d<4; d++) {
			int nr = r+direc[d][0];
			int nc = c+direc[d][1];
			if(0<=nr && nr<4 && 0<=nc && nc<4) {
				result.append(grid[nr][nc]);
				dfs(new int[] {nr,nc},level+1 );
				result.deleteCharAt(level);
			}
		}
		
	}

}

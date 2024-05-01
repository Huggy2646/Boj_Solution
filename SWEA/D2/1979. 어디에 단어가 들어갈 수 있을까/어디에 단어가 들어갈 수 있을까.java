import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int[][] direc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int result=0;
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] grid = new int[N][N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					grid[n][c] = Integer.parseInt(st.nextToken());
				}
			}
			//가로 빈칸
			for (int row = 0; row < N; row++) {
				int count=0;
				for (int col = 0; col < N; col++) {
					if(grid[row][col]==1) {
						count++;
					}
					else {
						if(count==k)
							result++;
						count=0;
					}
					if(col==N-1 && count==k)
						result++;
						
				}
			}
			//세로 빈칸
			for (int col = 0; col < N; col++) {
				int count=0;
				for (int row = 0; row < N; row++) {
					if(grid[row][col]==1) {
						count++;
					}
					else {
						if(count==k)
							result++;
						count=0;
					}
					if(row==N-1 && count==k)
						result++;
				}
			}
			
			
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
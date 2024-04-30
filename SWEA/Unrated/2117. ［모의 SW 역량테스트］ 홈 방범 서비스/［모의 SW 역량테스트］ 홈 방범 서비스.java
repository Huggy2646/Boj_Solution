import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	// 마름모 bfs로 ㄱㄱ
	static int[][] direc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			max = Integer.MIN_VALUE;
			String[] NM = br.readLine().split(" ");
			// N is size
			int N = Integer.parseInt(NM[0]);
			// M is pay
			int M = Integer.parseInt(NM[1]);

			// grid init
			int[][] grid = new int[N][N];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int nn = 0; nn < N; nn++) {
					grid[n][nn] = Integer.parseInt(st.nextToken());
				}
			}
//			for(int[] row:grid)
//				System.out.print(Arrays.toString(row));
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int buffer_result = 1;
					
					boolean[][] visited = new boolean[N][N];
					Queue<int[]> queue = new ArrayDeque<>();
					// queue init
					queue.offer(new int[] { r, c });
					visited[r][c] = true;
					int cnt = 0;
					int k = 1;
					// 한곳에서 k가 커지면서 ㄱㄱ
					while (!queue.isEmpty()) {
						int size = queue.size();
						for (int l = 0; l < size; l++) {
							int[] position = queue.poll();
							int row = position[0];
							int col = position[1];
							if (grid[row][col] == 1) {
								cnt++;
							}
							for (int d = 0; d < 4; d++) {
								int n_row = row + direc[d][0];
								int n_col = col + direc[d][1];
								if (0 <= n_row && n_row < N && 0 <= n_col && n_col < N && !visited[n_row][n_col]) {
									visited[n_row][n_col] = true;
									queue.offer(new int[] { n_row, n_col });
								}
							}

						}
						
						int pay = k * k + (k - 1) * (k - 1);
						int cost = (cnt * M) - pay;
						if (cost >= 0) {
							if(max < cnt)
								max = cnt;
						}
						k++;
					}
				}

			}
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
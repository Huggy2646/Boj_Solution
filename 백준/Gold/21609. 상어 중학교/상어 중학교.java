import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean flag = true;
	private static int N;
	private static int M;
	public static int[][] grid;
	private static boolean[][] visited;
	private static int[][] direct = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int[] groupPoint;
	private static int maxSize;
	private static int maxRainbow;

	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] N_M = br.readLine().split(" ");
		N = Integer.parseInt(N_M[0]);
		M = Integer.parseInt(N_M[1]);
		grid = new int[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < N; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			findGroup();
			if (flag) {
				break;
			}
			flag = true;
			result += (maxSize * maxSize);
			visited = new boolean[N][N];
			delBlock();

			gravityGrid();
			
			turnGrid();
			
			gravityGrid();

		}
		
		System.out.println(result);


	}

	private static void sout() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(grid[i][j]!=-2)
					System.out.print(grid[i][j]+"\t");
				else
					System.out.print(" \t");
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void turnGrid() {
		int[][] bufferGrid = new int[N][N];
		int index = 0;
		for (int c = N - 1; 0 <= c; c--) {
			for (int r = 0; r < N; r++) {
				bufferGrid[index][r] = grid[r][c];
			}
			index++;
		}
		for (int r = 0; r < N; r++) {
			grid[r] = bufferGrid[r].clone();
		}
	}

	private static void delBlock() {
		int r = groupPoint[0];
		int c = groupPoint[1];
		int point = grid[r][c];
		grid[r][c] = -2;
		boolean[][] bufferVisited = new boolean[N][N];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });
		bufferVisited[r][c] = true;
		while (!q.isEmpty()) {
			int[] p = q.poll();
			r = p[0];
			c = p[1];
			for (int d = 0; d < 4; d++) {
				int nr = direct[d][0] + r;
				int nc = direct[d][1] + c;
				if (bound(nr, nc) && !visited[nr][nc] && isSame(grid[nr][nc], point) && grid[nr][nc] != -1
						&& grid[nr][nc] != -2) {
					bufferVisited[nr][nc] = true;
					grid[nr][nc] = -2;
					q.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static void gravityGrid() {
		for (int c = 0; c < N; c++) {
			for (int r = N - 1; 0 <= r; r--) {
				if (grid[r][c] >= 0) {
					for (int k = r + 1; k < N; k++) {
						if (grid[k][c] == -1 || grid[k][c] >= 0)
							break;
						else {
							grid[k][c] = grid[k - 1][c];
							grid[k - 1][c] = -2;
						}
					}
				}
			}
		}

	}

	// bfs
	private static void findGroup() {
		groupPoint = new int[2];
		maxSize = Integer.MIN_VALUE;
		maxRainbow = Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (grid[r][c] == 0 || grid[r][c] == -1 || grid[r][c] == -2)
					continue;

				int bufferSize = 0;
				List<int[]> list = new LinkedList<>();
				Queue<int[]> rainbow = new ArrayDeque<>();
				int point = grid[r][c];
				int[] pointPosi = new int[] { r, c };
				Queue<int[]> q = new ArrayDeque<>();
				q.offer(new int[] { r, c });
				bufferSize++;
				visited[r][c] = true;
				while (!q.isEmpty()) {
					int size = q.size();
					for (int s = 0; s < size; s++) {
						int[] input = q.poll();
						list.add(input);
						int row = input[0];
						int col = input[1];
						for (int d = 0; d < 4; d++) {
							int nr = direct[d][0] + row;
							int nc = direct[d][1] + col;
							if (bound(nr, nc) && !visited[nr][nc] && isSame(grid[nr][nc], point) && grid[nr][nc] != -1
									&& grid[nr][nc] != -2) {
								if (grid[nr][nc] == 0) {
									rainbow.offer(new int[] { nr, nc });
								}
								visited[nr][nc] = true;
								bufferSize++;
								q.offer(new int[] { nr, nc });
							}
						}

					}
				} // while end

				// 보다 작으면 그룹이 있다고 판단(false == 브래이크를 하지 말라)
				if (list.size() >= 2)
					flag = false;
				if (maxSize == bufferSize) {
					if (maxRainbow < rainbow.size()) {
						maxRainbow = rainbow.size();
						groupPoint[0] = pointPosi[0];
						groupPoint[1] = pointPosi[1];
					}
					else if (maxRainbow == rainbow.size()) {
						if (groupPoint[0] < pointPosi[0]) {
							groupPoint[0] = pointPosi[0];
							groupPoint[1] = pointPosi[1];
						} else if (groupPoint[0] == pointPosi[0]) {
							if (groupPoint[1] < pointPosi[1]) {
								groupPoint[0] = pointPosi[0];
								groupPoint[1] = pointPosi[1];
							}
						}

					}
				} else if (maxSize < bufferSize) {
					maxRainbow=rainbow.size();
					maxSize = bufferSize;
					groupPoint[0] = pointPosi[0];
					groupPoint[1] = pointPosi[1];
				}

				// rainbow block visited init
				while (!rainbow.isEmpty()) {
					int[] rb = rainbow.poll();
					visited[rb[0]][rb[1]] = false;
				}

			}
		}

	}

	private static boolean isSame(int i, int point) {

		return i == point || i == 0;
	}

	private static boolean bound(int nr, int nc) {

		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}

}
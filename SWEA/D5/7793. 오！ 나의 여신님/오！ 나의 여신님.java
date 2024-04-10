import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static char[][] map;
	static boolean[][] visited;

	static int[] godposi;
	static int[][] direc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> devposi;
	static Queue<int[]> suposi;
	private static int N;
	private static int M;
	private static int result = 0;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for (int t = 0; t < T; t++) {
			String[] NM = br.readLine().split(" ");
			N = Integer.parseInt(NM[0]);
			M = Integer.parseInt(NM[1]);
			devposi = new ArrayDeque<>();
			suposi = new ArrayDeque<>();
			// visited
			visited = new boolean[N][M];
			// map init
			map = new char[N][M];
			for (int n = 0; n < N; n++) {
				String row = br.readLine();
				for (int m = 0; m < M; m++) {
					map[n][m] = row.charAt(m);
					if (map[n][m] == 'D')
						godposi = new int[] { n, m };
					else if (map[n][m] == 'S')
						suposi.offer(new int[] { n, m });
					else if (map[n][m] == '*')
						devposi.offer(new int[] { n, m });
				}
			}
			dfs();
			if(flag)
				sb.append("#").append(t+1).append(" ").append(result+1).append("\n");
			else
				sb.append("#").append(t+1).append(" ").append("GAME OVER").append("\n");
			flag=false;
			result=0;
		}
		System.out.println(sb);

	}

	private static void dfs() {

		while (!suposi.isEmpty()) {
			dev(devposi.size());
			suji(suposi.size());
			if (flag)
				break;
			result++;
		}

	}

	private static void dev(int size) {
		for (int s = 0; s < size; s++) {
			int[] posi = devposi.poll();
			for (int d = 0; d < 4; d++) {
				int nr = posi[0] + direc[d][0];
				int nc = posi[1] + direc[d][1];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 'D' && map[nr][nc] != 'X'
						&& map[nr][nc] != '*') {
					map[nr][nc] = '*';
					devposi.offer(new int[] { nr, nc });
				}
			}
		}

	}

	private static void suji(int size) {
		for (int s = 0; s < size; s++) {
			int[] posi = suposi.poll();
			for (int d = 0; d < 4; d++) {
				int nr = posi[0] + direc[d][0];
				int nc = posi[1] + direc[d][1];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && map[nr][nc] != 'X'
						&& map[nr][nc] != '*') {
					if(map[nr][nc]=='D') {
						flag=true;
						return;
					}
					suposi.offer(new int[] { nr, nc });
					visited[nr][nc] = true;


				}
			}
		}

	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int Tg;
	private static int Tb;
	private static char[][] grid;
	private static boolean[][] visited;
	private static int[][] direc = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {

			return Integer.compare(o1[2], o2[2]);
		}

	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new char[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		Tg = Integer.parseInt(st.nextToken());
		Tb = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				grid[i][j] = row.charAt(j);
				if (grid[i][j] == '*') {
					pq.offer(new int[] { i, j, 0 });
					visited[i][j] = true; // 이미 바이러스가 있는 곳은 방문한 것으로 처리
				}
			}
		}
		simul();
		check();

	}

	private static void check() {
		boolean flag = false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid[i][j]=='.' || grid[i][j]=='#') {
					flag=true;
					System.out.println((i+1)+" "+(j+1) );
				}
			}
		}
		if(!flag)
			System.out.println(-1);
	}

	private static void simul() {
//		int time=0;
		while(!pq.isEmpty()) {
			int[] input = pq.poll();
			int n = input[0];
			int m = input[1];
			int t = input[2];
			if(t>Tg)
				break;
			grid[n][m]='*';
			
			for(int d=0; d<4; d++) {
				int nn = n+direc[d][0];
				int nm = m+direc[d][1];
				if(isTrue(nn,nm)) {
					visited[nn][nm]=true;
					if(grid[nn][nm]=='#') {
						pq.offer(new int[] {nn,nm,t+Tb+1});
					}
					else if(grid[nn][nm]=='.') {
						pq.offer(new int[] {nn,nm,t+1});
					}
				}
			}
		}
		
	}

	private static boolean isTrue(int nn, int nm) {
		
		return 0<=nn && nn<N && 0<=nm && nm<M && !visited[nn][nm];
	}

}
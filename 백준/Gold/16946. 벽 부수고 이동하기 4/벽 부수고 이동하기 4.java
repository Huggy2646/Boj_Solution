import java.io.*;
import java.util.*;

public class Main {
	static int R;
	static int C;
	static char[][] grid;
	static boolean[][] visited;
	static int[][] answer;
	static int[][] countgrid;
	static Queue<int[]> Ws = new ArrayDeque<>();
	static Queue<int[]> Emptys = new ArrayDeque<>();
	static int[][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	static int part=1;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = new int[R][C];
		grid = new char[R][C];
		visited = new boolean[R][C];
		countgrid = new int[R][C];
		
		
		for (int r = 0; r < R; r++) {
			String row = br.readLine();
			for (int c = 0; c < C; c++) {
				grid[r][c] = row.charAt(c);
				if (grid[r][c] == '1')
					Ws.offer(new int[] { r, c });
				else
					Emptys.offer(new int[] { r, c });
			}
		}
		// 빈칸 갯수 파악
		while (!Emptys.isEmpty()) {
			int[] inp = Emptys.poll();
			if(countgrid[inp[0]][inp[1]]==0)
				bfs(inp);
		}
		
		while(!Ws.isEmpty()) {
			int [] w= Ws.poll();
			int r = w[0];
			int c = w[1];
			boolean [] visi = new boolean[part+2];
			int cnt=1;
			for(int d=0; d<4; d++) {
				int nr = r+direc[d][0];
				int nc = c+direc[d][1];
				if(isBound(nr,nc)&& !visi[countgrid[nr][nc]] && grid[nr][nc]=='0') {
					visi[countgrid[nr][nc]]=true;
					cnt+=map.get(countgrid[nr][nc]);
				}
			}
			answer[r][c]=cnt%10;
		}
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				sb.append(answer[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int[] inp) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(inp);
		int cnt = 1;
		countgrid[inp[0]][inp[1]]=part;
		visited[inp[0]][inp[1]] = true;
		while (!q.isEmpty()) {
			inp = q.poll();
			int r = inp[0];
			int c = inp[1];
			for (int d = 0; d < 4; d++) {
				int nr = r+direc[d][0];
				int nc = c+direc[d][1];
				if(isBound(nr,nc) && !visited[nr][nc] && grid[nr][nc]=='0') {
					visited[nr][nc]=true;
					cnt++;
					q.offer(new int[] {nr,nc});
					countgrid[nr][nc]=part;
				}
			}
		}
		map.put(part,cnt);
		part++;

	}

	private static boolean isBound(int nr, int nc) {
		return 0<=nr && nr<R && 0<=nc && nc<C;
	}
}
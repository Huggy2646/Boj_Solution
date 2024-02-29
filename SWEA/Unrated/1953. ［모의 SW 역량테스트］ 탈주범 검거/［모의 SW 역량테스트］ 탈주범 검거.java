import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
	static int [][] map;
	static boolean [][] visited;
	static int N,M,R,C,L;
	static Queue<position> queue;
	static class position{
		int r;
		int c;
		int level;
		public position(int r, int c, int level) {
			super();
			this.r = r;
			this.c = c;
			this.level=level;
		}
//		@Override
//		public String toString() {
//			return "position [r=" + r + ", c=" + c + "]";
//		}

	}
	/* 상,하,좌,우
	 * 상하좌우로 움직일때 갈 수 없는 곳 기본적으로 0인 곳은 못감 
	 * 상-> 좌우(3), 상우(4), 상좌(7) x
	 * 하-> 좌우(3),하좌(6), 하우 (5) x
	 * 좌-> 상하(2), 하좌(6), 상좌(7) x
	 * 우-> 상하(2), 상우(4), 하우(5) x
	 * */
	public static void up(int r,int c, int level) {
		// 위로 갔을 때 갈 수 있는 범위 체크 + 위에 적은 못 가는 파이프 모양 체크 + 방문여부 체크
		if(0<=r-1 && map[r-1][c]!=0 && map[r-1][c]!=3 && map[r-1][c]!=4 && map[r-1][c]!=7 && !visited[r-1][c]) {
			visited[r-1][c]=true;
			queue.offer(new position(r-1,c,level+1));
		}
	};
	public static void down(int r,int c, int level) {
		// 아래로 갔을 때 갈 수 있는 범위 체크 + 위에 적은 못 가는 파이프 모양 체크 + 방문여부 체크
		if(r+1<N && map[r+1][c]!=0 && map[r+1][c]!=3 && map[r+1][c]!=6 && map[r+1][c]!=5 && !visited[r+1][c]) {
			visited[r+1][c]=true;
			queue.offer(new position(r+1,c,level+1));
		}
	};
	public static void right(int r,int c, int level) {
		// 오른쪽으로 갔을 때 갈 수 있는 범위 체크 + 위에 적은 못 가는 파이프 모양 체크 + 방문여부 체크
		if(c+1<M && map[r][c+1]!=0 && map[r][c+1]!=2 && map[r][c+1]!=4 && map[r][c+1]!=5 && !visited[r][c+1]) {
			visited[r][c+1]=true;
			queue.offer(new position(r,c+1,level+1));
		}
	};
	public static void left(int r,int c, int level) {
		// 왼쪽으로 갔을 때 갈 수 있는 범위 체크 + 위에 적은 못 가는 파이프 모양 체크 + 방문여부 체크
		if(0<=c-1 && map[r][c-1]!=0 && map[r][c-1]!=2&& map[r][c-1]!=6&& map[r][c-1]!=7&& !visited[r][c-1]) {
			visited[r][c-1]=true;
			queue.offer(new position(r,c-1,level+1));
		}
	}
	public static void bfs(position p) {
		int r=p.r;
		int c=p.c;
		int level=p.level;

		if(level==L) {
			//시간이 되면 그냥 return이 됨
			visited[r][c]=true;
			return;
		}
		switch(map[r][c]) {
			
			case 1:
				//상
				up(r,c,level);
				//하
				down(r,c,level);
				//좌
				left(r,c,level);
				//우
				right(r,c,level);
				break;

			//상,하
			case 2:
				//상
				up(r,c,level);
				//하
				down(r,c,level);
				break;

			//좌,우
			case 3:
				//좌
				left(r,c,level);
				//우
				right(r,c,level);
				break;

			//상우
			case 4:
				up(r,c,level);
				right(r,c,level);
				break;

			//하우
			case 5:
				down(r,c,level);
				right(r,c,level);
				break;

			//하좌
			case 6:
				down(r,c,level);
				left(r,c,level);
				break;

			//상좌
			case 7:
				up(r,c,level);
				left(r,c,level);
				break;
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			String [] nmrcl = br.readLine().split(" ");
			N=Integer.parseInt(nmrcl[0]);
			M=Integer.parseInt(nmrcl[1]);
			R=Integer.parseInt(nmrcl[2]);
			C=Integer.parseInt(nmrcl[3]);
			L=Integer.parseInt(nmrcl[4]);
			map=new int[N][M];
			visited=new boolean[N][M];
			for(int n=0; n<N; n++) {
				map[n]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			queue = new ArrayDeque<>();
			queue.offer(new position(R,C,1));
			visited[R][C]=true;
			int count=0;
			//bfs로 방문을 하며 체크
			while(!queue.isEmpty()) {
				bfs(queue.poll());
				//queue에 들어간 것은 시간내에 들어간 것으로 판단하여 count를 높임
				//원래 visited에 저장된 방문했다는 값인 true의 갯수를 세려고 했지만 선영이의 아이디어로 이렇게 바꿈..
				count++;
			}
			sb.append("#").append(t+1).append(" ").append(count).append("\n");

		}
		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
		int [][][] cw_ccw = {{{-1,0},{0,1},{1,0},{0,-1}},{{1,0},{0,1},{-1,0},{0,-1}}};
		

		int[][] map = new int[R][C];
		//		List<int[]> dust_posi = new LinkedList<>();
		Queue<int[]> dust_posi = new ArrayDeque<>();
		int[][] m_posi = new int[2][2];

		int m_posi_r = 0;
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int c=0; c<C; c++) {
				map[r][c]=Integer.parseInt(st.nextToken());
				if(0<map[r][c]) {
					dust_posi.offer(new int[] {r,c});
				}
				if(map[r][c]==-1) {
					m_posi[m_posi_r][0]=r;
					m_posi[m_posi_r][1]=c;
					m_posi_r++;
				}
			}
		}

		for(int t=0; t<T; t++) {
			int[][] buffer_map =new int[R][C];
			// dust move
			// dfs
			int dust_num = dust_posi.size();
			for(int d=0; d<dust_num; d++) {
				int [] buffer_posi = dust_posi.poll();
				int r = buffer_posi[0];
				int c = buffer_posi[1];
				int value = map[r][c]/5;
				for(int i=0; i<4; i++) {
					int nr=r+direc[i][0];
					int nc=c+direc[i][1];
					if(0<=nr && nr<R && 0<=nc && nc<C && map[nr][nc]!=-1) {
						if(value==0)
							break;
//						if(buffer_map[nr][nc]==0 && map[nr][nc]==0) {
//							dust_posi.offer(new int[]{nr,nc});
//						}
						map[r][c]-=value;
						buffer_map[nr][nc]+=value;
					
						
					}
				}
//				dust_posi.offer(buffer_posi);
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					map[i][j]+=buffer_map[i][j];
				}
			}

			// 공청기 가동
			for(int i=0;i<2; i++) {
				int r = m_posi[i][0];
				int c = m_posi[i][1];
				for(int d =0; d<4; d++) {
					while(true) {
						int nr = r+cw_ccw[i][d][0];
						int nc = c+cw_ccw[i][d][1];
						if(i==0) {
							if(0<= nr && nr<=m_posi[i][0]&& 0<=nc && nc<C) {
								if(map[r][c]==-1) {
									r=nr;
									c=nc;
									continue;
								}
								if(map[nr][nc]==-1) {
									map[r][c]=0;
									r=nr;
									c=nc;
									continue;
								}
								
								map[r][c]=map[nr][nc];

								r=nr;
								c=nc;	

							}
							else
								break;
						}
						else {
							if(m_posi[i][0]<= nr && nr<R&& 0<=nc && nc<C) {
								if(map[r][c]==-1) {
									r=nr;
									c=nc;
									continue;
								}
								if(map[nr][nc]==-1) {
									map[r][c]=0;
									r=nr;
									c=nc;
									continue;
								}
								map[r][c]=map[nr][nc];

								r=nr;
								c=nc;	

							}
							else
								break;
						}


					}

				}
			}// 공청기 가동 끝
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(0<map[r][c])
						dust_posi.offer(new int [] {r,c});
				}
			}
		}
		int result = 0;
		while(!dust_posi.isEmpty()) {
			int [] buffer= dust_posi.poll();
			result += map[buffer[0]][buffer[1]];
		}
		System.out.println(result);
	}// main end

}// class end
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	//완탐 - dfs
	static int N;
	static int W;
	static int H;
	static int [][] map;
	static int []result;
	static int block_num=0;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W+1];
			result=new int [N];
			for(int h=0; h<H; h++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int w=0; w<W; w++) {
					map[h][w]=Integer.parseInt(st.nextToken());
					if(map[h][w]!=0) {
						block_num++;
					}
				}
			}
			dfs(0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
			block_num=0;
			min=Integer.MAX_VALUE;
		}

		System.out.println(sb);
		
	}
	public static void dfs(int level) {
		if(level==N) {
//			if(result[0]==2 || result[1]==2 || result[2]==2) {
//				System.out.println(Arrays.toString(result));
//			}
			//copy
			int [][] map_copy=new int[H][W];
			for(int h=0; h<H; h++) {
				map_copy[h]=Arrays.copyOf(map[h], W);
			}
			int del=simul(0,map_copy);
			min=del<min?del:min;

			return;
		}
		for(int i=0; i<W; i++) {
			result[level]=i;
			dfs(level+1);
		}
	}

	static int simul(int del,int[][] map_b){
		for(int n=0;n<N; n++) {
			Queue<Integer[]>queue = new ArrayDeque<>();
			int current_row=-1;
			int current_col=result[n];
			int oper=-1;
			int [][]direc={{-1,0},{1,0},{0,-1},{0,1}};//상하좌우 

			// 제일 위에 있는 블록 찾기
			for(int h=0; h<H; h++) {
				if(map_b[h][current_col]!=0) {
					current_row=h;
					oper=map_b[current_row][current_col];
					break;
				}
			}

			// 블록이 없으면 다음 볼 ㄱㄱ
			if(current_row==-1) {
				continue;
			}


			// 블록 값이 1이면 그 블록만 처리하고 다음 볼
			if(oper==1) {
				map_b[current_row][current_col]=0;
				continue;
			}
			queue.offer(new Integer[] {current_row,current_col});
			while(!queue.isEmpty()) {
				current_row=queue.peek()[0];
				current_col=queue.peek()[1];
				queue.poll();
				//현재블록 없애기
				int oper_2 = map_b[current_row][current_col];
				map_b[current_row][current_col]=0;
				
				//상하좌우로 블록 없애기
				for(int c=0; c<direc.length; c++) {
					int row=current_row;
					int col=current_col;
					

					// 블록 값 -1 만큼 반복
					for(int o=0; o<oper_2-1; o++) {
						row+=direc[c][0];
						col+=direc[c][1];
						//범위 내에 있으면
						if(0<=row && row<H && 0<=col && col<W) {
							// 0,1이면 0으로
							if(map_b[row][col]==0) {
								continue;
							}
							else if(map_b[row][col]==1) {
								map_b[row][col]=0;
							}
							// 2~9가 나오면 
							else {
								queue.add(new Integer[] {row,col});
								
							}
						}
						else
							break;

					}


				}
				
			}
			down(map_b);
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map_b[i][j]!=0){
					del++;
				};
			}
		}
		return del;
	}
	// 블럭 내리는 연산
	static void down(int [][] map_b) {
		for(int i=H-1; 0<i; i--) {
			for(int j=0;j<W; j++) {
				if(map_b[i][j]==0) {
					for(int k=i-1; 0<=k; k--) {
						if(map_b[k][j]!=0) {
							map_b[i][j]=map_b[k][j];
							map_b[k][j]=0;
							break;
						}
					}

				}
			}
		}
		
	}
}
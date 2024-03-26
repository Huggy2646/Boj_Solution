import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
	
	public class Main {
	    static int [][] direc = {{-1,0},{1,0},{0,-1},{0,1}};
	    static int N;
	    int min = Integer.MAX_VALUE;
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        int tc=1;
	        int [][]visited;
	        while(true) {
	            N = Integer.parseInt(br.readLine());
	            if(N==0)
	                break;
	            
	            sb.append("Problem ");
	            sb.append(tc);
	            sb.append(": ");
	            int map[][] = new int[N][N];
	            visited = new int[N][N];
	            for (int i = 0; i < visited.length; i++)
	                Arrays.fill(visited[i], Integer.MAX_VALUE);
	            
	            for(int n=0; n<N; n++) {
	                StringTokenizer st = new StringTokenizer(br.readLine()," ");
	                for(int nn=0;nn<N; nn++) {
	                    map[n][nn]=Integer.parseInt(st.nextToken());
	                }
	            }
	            //dfs
	            Queue<int []> queue = new ArrayDeque<>();
	            queue.offer(new int[] {0,0});
	            visited[0][0]=map[0][0];
	            
	            while(!queue.isEmpty()) {
	            	
	            	int [] buffer = queue.poll();
	            	int row = buffer[0];
	            	int col = buffer[1];

	            	for(int d=0; d<4; d++) {
	            		int nr = direc[d][0]+row;
	            		int nc = direc[d][1]+col;
	            		
	            		if(0<=nr && nr<N && 0<=nc && nc<N) {

//	            			if(visited[nr][nc]==0) {
//	            				visited[nr][nc]=visited[row][col]+map[nr][nc];
//	            				queue.offer(new int[] {nr,nc});
//	        				}
	            			if(visited[row][col]+map[nr][nc]<visited[nr][nc]) {
	            				visited[nr][nc]=visited[row][col]+map[nr][nc];
	            				queue.offer(new int[] {nr,nc});
	            			}
	            		}
	            	}
	            }
	            sb.append(visited[N-1][N-1]);
	            sb.append("\n");
	            tc++;
	        }
	        System.out.println(sb.toString());
	    }
	
	
	}
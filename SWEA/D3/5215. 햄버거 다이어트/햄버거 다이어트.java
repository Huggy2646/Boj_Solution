import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 부분집합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int food [][] = new int [N][2];
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				food[n][0] = Integer.parseInt(st.nextToken());
				food[n][1] = Integer.parseInt(st.nextToken());
			}
			int end = 1<<N;
			int max = Integer.MIN_VALUE;
			for(int i=1; i<end; i++) {
				int fav = 0;
				int cal = 0;
				for(int j=0; j<N; j++) {
					if((i&(1<<j))!=0) {
						fav+=food[j][0];
						cal+=food[j][1];
					}
					if(cal>=L) {
						break;
					}
				}
				if(cal<=L) {
					max=Integer.max(max, fav);
				}
				
			}
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
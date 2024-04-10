import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			String [] NB = br.readLine().split(" ");
			StringTokenizer st;
			int N = Integer.parseInt(NB[0]);
			int B = Integer.parseInt(NB[1]);
			int [] emps = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				emps[n]=Integer.parseInt(st.nextToken());
			}
			int min = Integer.MAX_VALUE;
			for(int n=0; n<(1<<N); n++) {
				int result = 0;
				for(int i=0; i<Integer.toBinaryString(n).length(); i++) {
					if((n & (1<<i))!=0) {

						result+=emps[i];
					}
					if(result>min) {
						break;
					}
				}

				if(result >= B) {
					min=Integer.min(min, result);
				}
			}
			sb.append("#").append(t+1).append(" ").append(Math.abs(min-B)).append("\n");
		}
		System.out.println(sb);
	}

}
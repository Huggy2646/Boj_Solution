import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			int sum=0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<10; i++) {
				sum+=Integer.parseInt(st.nextToken());
			}
			
			sb.append("#").append(t+1).append(" ").append(Math.round((double)sum/10)).append("\n");
		}
		System.out.println(sb);
	}
}
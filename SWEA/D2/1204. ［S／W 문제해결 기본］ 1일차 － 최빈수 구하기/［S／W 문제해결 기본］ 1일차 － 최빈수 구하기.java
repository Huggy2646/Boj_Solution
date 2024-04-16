import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static class Score implements Comparable<Score>{
		int key;
		int cnt;
		Score(int key,int cnt){
			this.key=key;
			this.cnt=cnt;
		}
		@Override
		public int compareTo(Score o) {
			
			return Integer.compare(this.cnt,o.cnt);
		}
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Score [] scores = new Score[101];

		for(int t=0; t<T; t++) {
			for(int i=0; i<101; i++) {
				scores[i] = new Score(i, 0);
			}
			int case_num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<1000; i++) {
				scores[Integer.parseInt(st.nextToken())].cnt++;
			}
				
			Arrays.sort(scores);
			sb.append("#").append(case_num).append(" ").append(scores[100].key).append("\n");
		}
		System.out.println(sb.toString());

		
	}
}
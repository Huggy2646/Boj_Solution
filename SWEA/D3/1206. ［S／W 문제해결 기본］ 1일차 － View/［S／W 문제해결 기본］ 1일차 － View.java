import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int[] b;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		StringTokenizer st =null;
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine(), " ");
			b = new int[N];
			for(int n=0; n<N; n++) {
				b[n]=Integer.parseInt(st.nextToken());
			}
			sb.append("#").append(t+1).append(" ").append(check()).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int check() {
		int cnt=0;
		for(int i=2; i<b.length-2; i++) {
			int curr = b[i];
			int left=curr-leftmax(i);
			int right=curr-rightmax(i);

			if(left>0 && right>0) {
				cnt+=Integer.min(left, right);
			}
			
		}
		return cnt;
		
	}

	private static int leftmax(int i) {
		int max = Integer.MIN_VALUE;
		for(int j=1; j<3; j++) {
			max=Integer.max(max,b[i-j]);
		}
		return max;
	}
	
	private static int rightmax(int i) {
		int max = Integer.MIN_VALUE;
		for(int j=1; j<3; j++) {
			max=Integer.max(max,b[i+j]);
		}
		return max;
	}

}
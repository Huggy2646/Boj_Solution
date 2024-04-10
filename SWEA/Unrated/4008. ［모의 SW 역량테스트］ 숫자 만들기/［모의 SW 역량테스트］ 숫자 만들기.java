import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int [] oper_result;
	private static int[] opers;
	private static int N;
	private static int cnt=0;
	private static int[] nums;
	private static int result;
	private static int max;
	private static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			opers = new int [4];
			oper_result=new int[N-1];
			nums = new int [N];
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<4; i++) {
				opers[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0;n<N;n++) {
				nums[n]=Integer.parseInt(st.nextToken());
			}
			
			permu(0);

			sb.append("#").append(t+1).append(" ").append(max-min).append("\n");
		}
		System.out.println(sb);
	}

	private static void permu(int level) {
		if(level==N-1) {
			calc();

		}
		for(int i=0; i<4; i++) {
			if(opers[i]!=0) {
				oper_result[level]=i;
				opers[i]--;
				permu(level+1);
				opers[i]++;
			}
			
		}
		
	}

	private static void calc() {
		result=nums[0];
		for(int i=0; i<N-1; i++) {
			// +
			if(oper_result[i]==0) {
				result+=nums[i+1];
			}
			// -
			else if(oper_result[i]==1) {
				result-=nums[i+1];
			}
			// *
			else if(oper_result[i]==2) {
				result*=nums[i+1];
			}
			// /
			else
				result=(int)(result/nums[i+1]);
		}
		max = Integer.max(result, max);
		min = Integer.min(result,min);
		
	}
}
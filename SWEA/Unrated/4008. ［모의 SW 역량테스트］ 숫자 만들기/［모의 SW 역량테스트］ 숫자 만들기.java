import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static String [] opers= {"+","-","*","/"};
	static int [] opers_count;
	static boolean[]visited;
	static int N;
	static int[] result;
	static int []numbers;
	static int max = Integer.MIN_VALUE;
	static int min= Integer.MAX_VALUE;
	public static void permu(int level) {
		if(level==N-1) {
			int operIndex=0;
			int buffer=numbers[0];			
			for(int i=1; i<N; i++) {
				int oper =result[operIndex];
				if(oper==0)
					buffer+=numbers[i];
				else if(oper==1)
					buffer-=numbers[i];
				else if(oper==2)
					buffer*=numbers[i];
				else
					buffer/=numbers[i];
				operIndex++;
			}
			max=max<buffer? buffer:max;
			min=buffer<min? buffer:min;
			return;
		}
		for(int i=0; i<opers_count.length; i++) {
			if(opers_count[i]!=0) {
				opers_count[i]--;
				result[level]=i;
				permu(level+1);
				opers_count[i]++;

			}
		}


	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T =Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			visited=new boolean[N-1];
			result=new int[N-1];
			opers_count=new int [N-1];
			opers_count=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			numbers=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				numbers[n]=Integer.parseInt(st.nextToken());
			}
			permu(0);
			sb.append("#").append(t+1).append(" ").append(max-min).append("\n");
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			}

		
			System.out.println(sb);
		}
		
}
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N;
	static boolean []visited;
	static int [] result;
	static int [] reverse_result;
	static int count=0;
	static int [][] power;
	static int reverse_count=0;
	static int min = Integer.MAX_VALUE;
	public static void make_combi(int level,int start) {
		if(level==N/2) {
			for(int i=0;i<N;i++) {
				if(count<N/2) {
					if(result[count]==i) {
						count++;
						continue;
					}

				}
				reverse_result[reverse_count]=i;
				reverse_count++;
			}
			int a=0;
			int b=0;
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<N/2; j++) {
					a+=power[result[i]][result[j]];
					b+=power[reverse_result[i]][reverse_result[j]];
				}
			}
			
			int buffer =  Math.abs(a-b);
//			System.out.println(buffer);
			min= buffer<min? buffer:min;
			
//			System.out.println(Arrays.toString(result));
//			System.out.println(Arrays.toString(reverse_result));
			reverse_count=0;
			count=0;
			return;
		}
		for(int i=start; i<N; i++) {
			if(!(visited[i])) {
				visited[i]=true;
				result[level]=i;
				make_combi(level+1, i+1);
				visited[i]=false;
			}

		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N=Integer.parseInt(br.readLine());
			power = new int[N][];
			visited = new boolean[N];
			result = new int[N/2];
			reverse_result = new int[N/2];
			for(int n=0; n<N; n++) {
				power[n]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			make_combi(0,0);
			sb.append("#").append(t+1).append(" ").append(min).append("\n");
			min=Integer.MAX_VALUE;
		}
		System.out.println(sb);
		
	}

}
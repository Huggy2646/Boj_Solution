import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static long [] input;
	private static int cnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		input = new long[N];
		for(int i=0; i<N; i++) {
			Long inp = Long.parseLong(st.nextToken());
			input[i]=inp;
		}
		Arrays.sort(input);
		for(int i=0; i<N; i++) {
			Long target = input[i];
			//two pointer
			int start = 0;
			int end = N-1;
			while(true) {

				if(start==i)
					start++;
				if(end==i)
					end--;
				
				if(start==end)
					break;
				
				if(target == input[start]+input[end]) {
					cnt++;
					break;
				}
					
				else if(target < input[start]+input[end]) {
					end--;
				}
				else if(target > input[start]+input[end]) {
					start++;
				}
			}
		}
		System.out.println(cnt);
		

		
	}

}
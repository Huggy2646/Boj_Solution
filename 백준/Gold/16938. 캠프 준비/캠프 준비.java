import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int L;
	static int R;
	static int X;
	static int [] problem;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		problem = new int[N];
		int answer=0;
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			problem[n]=Integer.parseInt(st.nextToken());
		}
		
		//subset
		for(int i=0; i<(1<<N); i++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if((i&(1<<j))!=0) {
					sum+=problem[j];
					max = Integer.max(max, problem[j]);
					min = Integer.min(min, problem[j]);
					cnt++;
				}
			}
			if(2<=cnt && X<=max-min && L<=sum && sum<=R) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}

}
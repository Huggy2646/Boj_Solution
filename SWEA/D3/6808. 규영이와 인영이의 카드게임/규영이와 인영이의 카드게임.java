import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N=9;
	int C=9;
	static int [] kyue;
	static int [] in;
	static int [] visit;
	static int [] cards;
	static int [] buffer_result;
	static int win=0;
	static int lose=0;
	public static void check() {
		int kyue_point=0;
		int in_point=0;
		for(int i=0; i<N; i++) {
			if(kyue[i]<buffer_result[i])
				in_point+=buffer_result[i]+kyue[i];
			else
				kyue_point+=buffer_result[i]+kyue[i];		
		}
		if(kyue_point<in_point) lose++;
		else if(in_point<kyue_point) win++;
	}
	public static void permu(int cnt) {
		//기저, 순열 하나 완성
		if(cnt==N) {
			check();
			return;
		}
		//공통
		for(int i=0; i<in.length; i++) {
			if(visit[i]==0) {
				buffer_result[cnt]=in[i];
				visit[i]=1;
				permu(cnt+1);
				visit[i]=0;
			}
		}
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input.inp"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0 ; t<T; t++) {
			//init
			kyue=new int[9];
			in = new int[9];
			cards = new int[19];
			visit = new int[9];
			buffer_result=new int[9];
			String [] buffer_array=br.readLine().split(" ");
			int index=0;
			for(String s: buffer_array) {
				kyue[index++]=Integer.parseInt(s);
				cards[Integer.parseInt(s)]=1;
			}
			index=0;
			for(int i=1; i<19; i++) {
				if(cards[i]==0) 
					in[index++]=i;
			}
			//System.out.println(Arrays.toString(in));
			
			//모든 경우의 순열
			permu(0);

			
			//출력값
			sb.append("#").append(t+1).append(" ").append(win).append(" ").append(lose).append("\n");
			
			//reset
			win=0;
			lose=0;
			
			
		}
		System.out.println(sb);
	}

}
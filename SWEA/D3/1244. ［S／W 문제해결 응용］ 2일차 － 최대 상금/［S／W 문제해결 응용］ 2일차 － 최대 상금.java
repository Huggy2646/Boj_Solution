import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private static char[] number;
	private static int k;
	private static List<int[]> total_result;
	private static boolean [] visited;
	private static int [] result;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			answer = Integer.MIN_VALUE;
			String []input = br.readLine().split(" ");

			result = new int [2];
			number = input[0].toCharArray();
			
			total_result  = new ArrayList<>();
			visited = new boolean[number.length];
			k = Integer.parseInt(input[1]);
			
			combi_first(0,0);
			
			result = new int[k];
			
			combi_second(0,0);
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
	}

	private static void combi_second(int level, int curr) {
		if(level==k) {
			change();
			return;
		}
		for(int i=curr; i<total_result.size(); i++) {
			result[level]=i;
			combi_second(level+1,i);
		}
		
	}

	private static void change() {
		char[] result_buffer = number.clone();
		for(int i=0; i<result.length; i++) {
			int[] buffer = total_result.get(result[i]);
			int a = buffer[0];
			int b = buffer[1];
			char a_buffer=result_buffer[a];
			result_buffer[a]=result_buffer[b];
			result_buffer[b]=a_buffer;
		}
		StringBuilder buffer_an = new StringBuilder();
		for(int i=0; i<result_buffer.length; i++)
			buffer_an.append(result_buffer[i]);
		answer = Integer.max(answer, Integer.parseInt(buffer_an.toString()));
		

		
	}

	private static void combi_first(int level, int curr) {
		if(level==2) {
			total_result.add(result.clone());
			return;
		}
		for(int i=curr; i<number.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				result[level]=i;
				combi_first(level+1,i);
				visited[i]=false;
			}
		}
		
	}
}
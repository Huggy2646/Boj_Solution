import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	private static class t{
		public int index;
		public int len;
		public int result;
		public t(int index, int len, int result){
			this.index=index;
			this.len = len;
			this.result = result;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int []ts=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int []result_a = new int[N];
		Stack<t> stc = new Stack<t>();
		
		for(int i=0; i<N; i++) {
			if(stc.isEmpty())
				stc.push(new t(i,ts[i],0));
			else {
				if(stc.peek().len < ts[i]) {
					t buff = stc.pop();
					result_a[buff.index]=buff.result;
					while(true) {
						if(stc.isEmpty()) {
							stc.push(new t(i,ts[i],0));
							break;
						}
							
						else if(ts[i]<stc.peek().len) {
							stc.push(new t(i,ts[i],stc.peek().index+1));
							break;
						}
//						sb.append(stc.pop().result);
						buff = stc.pop();
						result_a[buff.index]=buff.result;
						
					}
					
				}
					
				else if(ts[i]<stc.peek().len) {
					stc.push(new t(i,ts[i],stc.peek().index+1));
				}
					
			}
		}
		// 끝나면 다 빼기
		

		while(!stc.empty()) {
			t buff = stc.pop();
			result_a[buff.index]=buff.result;
		}
		for(int b : result_a) {
			System.out.print(b+" ");
		}
	}

}
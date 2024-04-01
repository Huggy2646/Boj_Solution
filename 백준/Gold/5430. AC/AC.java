import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		for(int t=0; t<T; t++) {
			String cmds = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String buffer = br.readLine();
			Deque<String> numbers = new ArrayDeque<>();
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<buffer.length(); i++) {
				char curr = buffer.charAt(i);
				if(curr=='[') continue;
				else if(curr==',' || curr==']') {
					if(sb.toString().length()==0)
						break;
					numbers.offerLast(sb.toString());
					sb = new StringBuilder();
				} 
				else {
					sb.append(curr);
				}
			}
			
			// 0=원상태 배열, 1=반대 배열
			int toggle = 0;
			int error_toggle = 0;
			for(int i=0; i<cmds.length(); i++) {
				char cmd = cmds.charAt(i);
				switch(cmd) {
					case 'R':
						toggle^=1;
						break;
					case 'D':
						if(numbers.isEmpty())
							error_toggle=1;
						if(toggle==0) {
							numbers.pollFirst();
						}
						if(toggle==1) {
							numbers.pollLast();
						}
						break;
				}
			}
			
			if(error_toggle==1)
				result.append("error");
			else {
				result.append("[");
				while(!(numbers.isEmpty())) {
					if(toggle==0) {
						result.append(numbers.pollFirst());
						if(numbers.size()!=0) {
							result.append(",");
						}
					}
					if(toggle==1) {
						result.append(numbers.pollLast());
						if(numbers.size()!=0) {
							result.append(",");
						}
					}
				}
				result.append("]");
			}
			
			result.append("\n");
		}
	System.out.println(result.toString());
	}
}
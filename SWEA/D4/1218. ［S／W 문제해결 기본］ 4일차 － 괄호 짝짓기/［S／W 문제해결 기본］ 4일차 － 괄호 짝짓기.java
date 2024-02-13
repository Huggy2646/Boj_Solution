import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t=0; t<10; t++) {
			Stack<Character> s = new Stack<>();
			sb.append("#").append(t+1).append(" ");
			int s_len=Integer.parseInt(br.readLine());
			String string = br.readLine();
			//init


			for(int i=0; i<s_len; i++) {//'()', '[]', '{}', '<>'
				if(s.empty())
					s.push(string.charAt(i));
				else {
					char a = s.peek();
					char b = string.charAt(i);

					switch (a){
					case '(':
						if(b==')')
							s.pop();
						else
							s.push(b);
						break;
					case '[':
						if(b==']')
							s.pop();
						else
							s.push(b);
						break;
					case '{':
						if(b=='}')
							s.pop();
						else
							s.push(b);
						break;
					case '<':
						if(b=='>')
							s.pop();
						else
							s.push(b);
						break;
					default:
						s.push(b);
					}
				}
				
			}
			if(s.empty()) {
				sb.append(1);
			}
			else
				sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
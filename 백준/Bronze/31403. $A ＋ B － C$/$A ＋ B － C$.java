import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = 0;
		String b = "";
		
		for(int i=0; i<3; i++) {
			String num = br.readLine();
			
			if(i<2) {
				a += Integer.parseInt(num);
				b += num;
			} else {
				a -= Integer.parseInt(num);
				b = Integer.toString(Integer.parseInt(b)-Integer.parseInt(num));
			}
		}
		
		StringBuilder sb  = new StringBuilder();
		sb.append(a).append("\n").append(b);
		System.out.println(sb);

	}

}

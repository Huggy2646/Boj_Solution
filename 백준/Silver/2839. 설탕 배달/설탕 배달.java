import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("res/boj_2839.inp"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		int count=0;
		while(true) {
			if(num ==0) {
				System.out.println(count);
				break;
			}
			if(num<3) {
				System.out.println(-1);
				break;
			}
				
			if(num%5==0) {
				count+=num/5;
				num%=5;
			}	
			else {
				num -= 3;
				count ++;
			}
		}
	}
}
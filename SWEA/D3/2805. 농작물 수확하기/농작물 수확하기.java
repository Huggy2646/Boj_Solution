import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			int result =0;
			int size = Integer.parseInt(br.readLine());
			int [][]grid = new int[size][size];
			
			for(int i=0; i<size; i++) {
				/*grid[i]=Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();*/
				String s = br.readLine();
				for(int j=0; j<s.length(); j++) {
					grid[i][j] = s.charAt(j)-'0';
				}
			}
			int start = size/2;
			int end = size/2;
			//위 역삼각형
			for(int i=0; i<=size/2; i++) {
				for(int j=start; j<=end; j++) {

					result +=grid[i][j];
				}
				start--;
				end++;
			}
			start=1;
			end=size-2;
			//아래 사다리꼴
			for(int i=size/2+1; i<size; i++) {
				for(int j=start; j<=end; j++) {

					result +=grid[i][j];
				}

				start++;
				end--;
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

}
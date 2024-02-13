import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			//index 0 == 과자 갯수
			//index 1 == 무게
			int [] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int [] snacks = new int[NM[0]];
			snacks=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int w=NM[1];
			int len = NM[0];
			int start=0;
			int end=NM[0]-1;
			int buffer=0;
			int result=-1;
			
			boolean a= false;
			for(int i=0; i<len-1;i++) {
				if(a) {
					a=false;
					break;
				}
				for(int j=i+1;j<len;j++) {
					if(snacks[i]+snacks[j]==w) {
						a=true;
						result=w;
						break;
					}
					else if(snacks[i]+snacks[j]<w) {
						if(result<snacks[i]+snacks[j])
							result=snacks[i]+snacks[j];
					}
				}
			}
			sb.append(result);
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
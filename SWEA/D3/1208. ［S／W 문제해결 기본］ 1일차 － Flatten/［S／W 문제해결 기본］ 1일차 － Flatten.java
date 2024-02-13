import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 10;
		for(int t=0; t<T; t++) {
			sb.append("#").append(t+1).append(" ");
			int dump = Integer.parseInt(br.readLine());
			String boxs[] = br.readLine().split(" ");
			List<String> buffer = new ArrayList<>(Arrays.asList(boxs));
			List<Integer> ls = new ArrayList<>();
			for(int i=0; i<buffer.size(); i++) {
				ls.add(Integer.parseInt(buffer.get(i)));
			}

			
			Collections.sort(ls);

			for(int i=0; i<dump; i++) {
				ls.set(99, (ls.get(99)-1));
				ls.set(0, ls.get(0)+1);
				Collections.sort(ls);
				
				if(ls.get(ls.size()-1)==ls.get(0) || ls.get(ls.size()-1)-ls.get(0)==1){
					if(ls.get(ls.size()-1)==ls.get(0))
						System.out.println(0);
					else
						System.out.println(1);
					break;
				}
			}
			sb.append(ls.get(ls.size()-1)-ls.get(0)).append("\n");
		}
		System.out.println(sb);
	}

}
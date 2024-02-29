import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder result= new StringBuilder();
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		Set<String> set;
		for(int t=0; t<T; t++) {
			set=new HashSet<>();
			
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
	
			sb.append(br.readLine());
			int window_size=sb.length()/4;
//			char []code=new char[window_size];
			String code = "";

			for(int i=0; i<window_size; i++) {
				for(int j=1; j<sb.length()+1; j++) {
					if(j%window_size==0) {
						code+=Character.toString(sb.charAt(j-1));
						set.add(code);
						code="";
					}
					else
						code+=Character.toString(sb.charAt(j-1));
						
				}
				sb.insert(0, sb.charAt(sb.length()-1));
				sb.deleteCharAt(sb.length()-1);
			}
			List<String> list = new ArrayList<>(set);	
			Collections.sort(list,new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					
					return o2.compareTo(o1);
				}
			});
			

			result.append("#").append(t+1).append(" ").append(Integer.parseInt(list.get(K-1),16)).append("\n");

			sb= new StringBuilder();
		}
		System.out.println(result);
	}

}
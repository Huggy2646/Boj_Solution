import java.io.*;
import java.util.*;

public class Main {
	public static class Style{
		public int power;
		public String name;
		Style(String name,int power){
			this.power=power;
			this.name=name;
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Style> list = new ArrayList<>(); 
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			if(list.size()!=0 && (list.get(list.size()-1).power==power))
			{
				continue;
			}
			list.add(new Style(name,power));
			
		}
		for(int m=0; m<M; m++) {
			int number = Integer.parseInt(br.readLine());
			//binary search
			int start = 0;
			int end=list.size()-1;
			while(true) {
				int mid=(start+end)/2;
				if(list.get(mid).power<number) {
					start=mid+1;
				}
				else if(number<list.get(mid).power) {
					end=mid-1;
				}
				else if(number==list.get(mid).power) {
					sb.append(list.get(mid).name).append('\n');
					break;
				}
				if(end<start) {
					String buffer;
					if(mid==list.size()-1)
						buffer=list.get(mid).name;
					else 
						buffer = list.get(mid).power < number ? list.get(mid+1).name:list.get(mid).name;
					sb.append(buffer).append('\n');
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
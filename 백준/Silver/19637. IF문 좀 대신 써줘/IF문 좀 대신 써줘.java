package boj_19637_IF문좀대신써줘;

import java.io.*;
import java.util.*;

public class Solution {
	//데이터 class
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
		//data init
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			//2번 예제같이 같은 숫자가 들어올 경우에는 뒤에 들어온 숫자는 필요없기 때문에 그냥 넘겨줌
			if(list.size()!=0 && (list.get(list.size()-1).power==power))
				continue;
			
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
				//같으면 바로 반환 (이하이니깐 포함됨)
				else if(number==list.get(mid).power) {
					sb.append(list.get(mid).name).append('\n');
					break;
				}
				//기저
				if(end<start) {
					String buffer;
					// 끝까지 해도 안왔는데 mid값이 마지막 값을 가리키고 있으면 그 값이 칭호
					// (문제에서 없는 칭호(넘어 가는 값이 없다고 )는 주어지지 않는다고 함)
					if(mid==list.size()-1)
						buffer=list.get(mid).name;
					else
						// 아니라면 초과 이하를 판단해야됨
						// 만약에 mid에 있는 값이 number랑 같지 않고(위에서 걸렀음) 작으면
						// mid ~ mid+1의 값을 가짐 그래서 mid+1의 칭호를 가짐
						// mid가 number보다 크면 mid-1 ~ mid의 값임 그래서 mid의 칭호를 가짐
						buffer = list.get(mid).power < number ? list.get(mid+1).name:list.get(mid).name;
					sb.append(buffer).append('\n');
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}

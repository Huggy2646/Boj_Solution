import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			Map<Integer,Integer> map = new HashMap<>();
			int cnt = 0;
			PriorityQueue<Integer> pq_max = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o2, o1);
				}
	
			});
			
			PriorityQueue<Integer> pq_min = new PriorityQueue<>(new Comparator<Integer>() {
	
				@Override
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(o1, o2);
				}
	
			});
			
			int c_num = Integer.parseInt(br.readLine());
			for(int c=0; c<c_num; c++) {
				String[] cmd = br.readLine().split(" ");
				if(cmd[0].equals("I")) {
					cnt++;
					int num = Integer.parseInt(cmd[1]);
					pq_max.offer(num);
					pq_min.offer(num);
					if(map.get(num)==null)
						map.put(num,1);
					else
						map.replace(num,map.get(num)+1);
				}
				else if(cmd[0].equals("D")) {
					if(cnt==0) {
						continue;
					}	
					if(cmd[1].equals("1")) {
						while(!pq_max.isEmpty()) {
							Integer popnum = pq_max.poll();
							int v = map.get(popnum);
							if(v!=0) {
								map.replace(popnum, v-1);
								cnt--;
								break;
							}
						}
					}	
					else {
						while(!pq_min.isEmpty()) {
							Integer popnum = pq_min.poll();
							int v = map.get(popnum);
							if(v!=0) {
								map.replace(popnum, v-1);
								cnt--;
								break;
							}
						}

					}
				}

			}

			if(cnt==0)
				sb.append("EMPTY").append("\n");
			else {
				while(!pq_max.isEmpty()) {
					int max = pq_max.poll();
					int v = map.get(max);
					if(v!=0) {
						sb.append(max).append(" ");
						break;
					}
				}
				while(!pq_min.isEmpty()) {
					int min = pq_min.poll();
					int v = map.get(min);
					if(v!=0) {
						sb.append(min).append("\n");
						break;
					}
				}
			}

		}
		System.out.println(sb);

	}
}
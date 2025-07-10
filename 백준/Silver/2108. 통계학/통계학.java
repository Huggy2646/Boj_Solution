
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		
		int mid = (n)/2;
		int sum = 0;
		
		int maxCnt = 0;
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> keys = new ArrayList<>();
		List<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			sum+=num;
			list.add(num);
			int newCnt;
			// 빈도수 넣기
			if(map.get(num) == null) {
				newCnt=1;
				map.put(num, 1);
				keys.add(num);
			}else {
				newCnt= map.get(num)+1;
			}
			map.put(num, newCnt);
			maxCnt = maxCnt < newCnt ? newCnt:maxCnt;
		}
		
		
		for(Integer key:keys) {
			if(map.get(key) == maxCnt)
				pq.offer(key);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(sum/(n*1.0))).append("\n").append(list.get(mid)).append("\n");
		
		if(1<pq.size()) {
			pq.poll();
			sb.append(pq.poll()).append("\n");
		}else {
			sb.append(pq.poll()).append("\n");
		}
		
		sb.append(list.get(n-1)-list.get(0));
		
		
		System.out.println(sb);

	}

}
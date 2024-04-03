import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
	public static class Book{
		int P;
		int L;
		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Book(int p, int l) {
			super();
			P = p;
			L = l;
		}
		

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Book) {
				Book book = (Book) obj;
				return ((Book) obj).P==this.P;	
			}
			return false;
		}
		@Override
		public String toString() {
			return "Book [P=" + P + ", L=" + L + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer>map = new HashMap<>();
		
		PriorityQueue<Book> pq_max = new PriorityQueue<>(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				if(o1.L==o2.L) {
					return o2.P-o1.P;
				}
				return Integer.compare(o2.L, o1.L);
			}
			
		});
		
		PriorityQueue<Book> pq_min = new PriorityQueue<>(new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				if(o1.L==o2.L) {
					return o1.P-o2.P;
				}
				return Integer.compare(o1.L, o2.L);
			}
			
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int n=0; n<N; n++) {
			String [] pl = br.readLine().split(" ");
			int p=Integer.parseInt(pl[0]);
			int l=Integer.parseInt(pl[1]);
			Book book = new Book(p,l);
			pq_max.offer(book);
			pq_min.offer(book);
			map.put(p, l);
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int m=0; m<M; m++) {
			String [] cmd = br.readLine().split(" ");
			if(cmd[0].equals("add")) {
				int p = Integer.parseInt(cmd[1]);
				int l = Integer.parseInt(cmd[2]);
				Book book = new Book(p,l);
				pq_max.offer(book);
				pq_min.offer(book);
				map.put(p, l);
			}
			else if(cmd[0].equals("solved")) {
				int p = Integer.parseInt(cmd[1]);
				map.replace(p, 0);
				
			}
			else if(cmd[0].equals("recommend")) {
				String s = cmd[1];
				if(s.equals("-1"))
					while(!pq_min.isEmpty()) {
						if(map.get(pq_min.peek().P)!=0) {
							sb.append(pq_min.peek().P).append("\n");
							break;
						}
							
						pq_min.poll();
					}

				else {
					while(!pq_max.isEmpty()) {
						if(map.get(pq_max.peek().P)==pq_max.peek().L) {
							sb.append(pq_max.peek().P).append("\n");
							break;
						}
						pq_max.poll();
					}
				}
					
			}
				
		}
		System.out.println(sb.toString());
	}

}
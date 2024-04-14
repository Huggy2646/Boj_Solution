import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class robot_part{
		int cnt=1;
		int my=0;
		int parent=0;
		public robot_part() {
			super();
		}
		public robot_part(int cnt, int my, int parent) {
			super();
			this.cnt = cnt;
			this.my = my;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "robot_part [cnt=" + cnt + ", my=" + my + ", parent=" + parent + "]";
		}
	}
	
	static robot_part[] parts;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		parts = new robot_part[1000001];
		for(int i=1; i<1000001; i++) {
			parts[i]=new robot_part(1,i,i);
		}
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			String cmd = st.nextToken();

			
			if(cmd.equals("I")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			else {
				int c = Integer.parseInt(st.nextToken());
				while(true) {
					if(parts[c].parent==c) {
						sb.append(parts[parts[c].parent].cnt).append("\n");
						break;
					}
					else
						c=parts[c].parent;
				}

			}
		}
		System.out.println(sb.toString());
	}
	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if(aroot!=broot) {
			if(aroot<broot) {
				parts[broot].parent=aroot;
				parts[aroot].cnt+=parts[broot].cnt;
				
			}
			else{
				parts[aroot].parent=broot;
				parts[broot].cnt+=parts[aroot].cnt;
			}
				
		}
		
	}
	private static int find(int num) {
		if(parts[num].parent==num)
			return num;
		return parts[num].parent=find(parts[num].parent);
	}

}
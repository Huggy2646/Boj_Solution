import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int []parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] VE = br.readLine().split(" ");
		
		int V = Integer.parseInt(VE[0]);
		int E = Integer.parseInt(VE[1]);
		int []degree= new int[V+1]; 
		parents = new int[V+1];
		for(int e=0; e<E; e++) {
			String[] edges = br.readLine().split(" ");
			int a = Integer.parseInt(edges[0]);
			int b = Integer.parseInt(edges[1]);
			
			union(a,b);
			
			degree[a]++;
			degree[b]++;
		}
		
		int root_cnt=0;
		for(int i=1; i<V+1; i++) {
			if(parents[i]==0)
				root_cnt++;
			if(root_cnt==2) {
				System.out.println("NO");
				return;
			}
		}
		int odd=0;
		for(int v=1; v<V; v++) {
			if(degree[v]%2!=0)
				odd++;
			if(odd>2) {
				System.out.println("NO");
				return;
			}
				
		}
		System.out.println("YES");
		

	}
	private static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
        if (aroot != broot) {
            if (aroot < broot)
                parents[broot] = aroot;
            else
                parents[aroot] = broot;
        }
		
	}
	private static int find(int num) {
		if(parents[num]==0)
			return num;
		return parents[num]=find(parents[num]);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	private static int N;
	private static int M;
	private static int[] parents;
	private static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] NM = br.readLine().split(" ");
		N = Integer.parseInt(NM[0]);
		M = Integer.parseInt(NM[1]);
		parents=new int[N+1];
		for(int n=1; n<N+1; n++) {
			parents[n]=n;
		}
		for(int m=0; m<M; m++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			if(!union(a,b))
				cnt++;
		}
		for(int n=1; n<N+1; n++) {
			if(parents[n]==n) {
				for(int nn=1; nn<N+1; nn++) {
					if(nn!=n && parents[nn]==nn) {
						union(n,nn);
						cnt++;
					}
				}
			}
			
		}
		System.out.println(cnt);
	}
	private static boolean union(int a, int b) {
		int aroot = find(a);
		int broot =find(b);
		if(aroot==broot)
			return false;
		parents[aroot]=broot;
		return true;
	}
	private static int find(int num) {
		if(parents[num]==num) {
			return num;
		}
		return parents[num]=find(parents[num]);
	}
}
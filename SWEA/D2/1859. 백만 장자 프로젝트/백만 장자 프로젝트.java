import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        long[] prices;
                
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o2[1], o1[1]);
                }
            });
            int N = Integer.parseInt(br.readLine());
            st=new StringTokenizer(br.readLine()," ");
            prices = new long[N];
            long[] buffer;
            long result=0;
            for(int n=0; n<N; n++) {
                long price = Integer.parseInt(st.nextToken());
                prices[n]=price;
                //{날짜, 가격}
                pq.offer(new long[] {n,price});
            }
            buffer = pq.poll();
            boolean flag=false;
            for(int n=0; n<N; n++) {
            	if(flag)
            		break;
                if(n<buffer[0])
                    result+=(buffer[1]-prices[n]);
                else {
                    while(true) {
                    	if(pq.isEmpty())
                    		break;
                    	buffer = pq.poll();
                    	if(buffer[0]<n)
                    		continue;
                    	else
                    		break;
                    }
                }
                    
            }
            
            sb.append("#").append(t+1).append(" ").append(result).append("\n");
            
        }
        System.out.println(sb.toString());
    }

}
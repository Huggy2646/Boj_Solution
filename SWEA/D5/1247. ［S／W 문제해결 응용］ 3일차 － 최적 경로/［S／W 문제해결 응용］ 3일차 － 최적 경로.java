import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
  
public class Solution {
    static int N;
    static int []start_position;
    static int []home_position;
    static int [][] cus_position;
    static boolean[] used;
  
    static int count;
    static int min;
    public static void dfs(int level,int cnt,int pre_r,int pre_c,int pre_dis) {
        int dis;
        if(level==N) {
            count++;
  
            dis = pre_dis+(Math.abs(pre_r-home_position[0])+Math.abs(pre_c-home_position[1]));
            if(dis<min)
                min=dis;
  
            return;
        }
        for(int i=0; i<N;i++) {
            if(used[i])
                continue;
              
            int r=cus_position[i][0];
            int c=cus_position[i][1];
            dis = (Math.abs(pre_r-r)+Math.abs(pre_c-c))+pre_dis;
  
            //가지치기
            if(min<dis)
                return;
              
            used[i]=true;
            dfs(level+1,cnt+1,r,c,dis);
            used[i]=false;
              
        }
          
          
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
          
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
          
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            sb.append("#").append(t+1).append(" ");
            count=0;
            min=Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            String [] position = br.readLine().split(" ");
            used=new boolean[N];
  
            //init
            start_position=new int[2];
            start_position[0]=Integer.parseInt(position[0]);
            start_position[1]=Integer.parseInt(position[1]);
              
            home_position=new int[2];
            home_position[0]=Integer.parseInt(position[2]);
            home_position[1]=Integer.parseInt(position[3]);
              
            cus_position=new int[N][2];
            int index=0;
            for(int i=4; i<position.length; i+=2) {
                cus_position[index][0]=Integer.parseInt(position[i]);
                cus_position[index][1]=Integer.parseInt(position[i+1]);
                index++;
            }
            dfs(0,0,start_position[0],start_position[1],0);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
  
}
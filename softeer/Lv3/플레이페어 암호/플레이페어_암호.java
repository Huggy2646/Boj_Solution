import java.io.*;
import java.util.*;

public class Main {
    static boolean [] visited=new boolean [26];
    static char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static char [][] grid = new char[5][5];
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();
        int same = 0;
        int index = 0;
        //row의 길이가 5이니깐 일차원 배열 index/5는 row값이 되고 , index%5는 column값이 된다.
        for(int k=0; k<key.length(); k++){
	          // same을 계산하는 이유는 같은 알파벳은 빠지기 때문에 index들이 빠진만큼 앞으로 땡겨짐
            int row = (k-same)/5;
            int col = (k-same)%5;
            if(!visited[key.charAt(k)-'A']){
                visited[key.charAt(k)-'A']=true;
                grid[row][col]=key.charAt(k);
                //key를 다 넣고 다시 나머지 알파벳을 넣을때 사용할 index값
                index++;
            }
            else{
                same++;
            }
                
        }
        //남은 알파벳 넣기
        for(int i=0; i<alpha.length; i++){
            if(!visited[i] && alpha[i]!='J'){
                visited[i]=true;
                int row = index/5;
                int col = index%5;
                grid[row][col]=alpha[i];
                index++;

            }
            

        }
				
        List <String[]> list = new ArrayList<>();
        // message를 2개의 쌍으로 만들 때 하나씩 빼기 위해  Queue를 사용
        Queue<String> queue =new ArrayDeque<>(Arrays.asList(message.split("")));
        // 쌍이 안맞아서 하나 남는 경우와 모든것이 쌍으로 만들어 질때 까지 반복
        while(queue.size()!=1 && queue.size()!=0){
            String front = queue.poll();
            if(!front.equals(queue.peek())){
                list.add(new String[]{front,queue.poll()});
            }
            else{
                if(front.equals("X"))
                    list.add(new String[]{front,"Q"});
                else
                    list.add(new String[]{front,"X"});    
            }
            
        }
        if(queue.size()==1){
            list.add(new String[]{queue.poll(),"X"});
        }

				//grid에서 2개의 쌍들의 위치를 찾기 위한 코드
        for(String [] strs : list){
		        //찾은 인덱스 값들이 저장됨
            int[][] find_index=new int[2][2];
            for(int k=0;k<2; k++){
                for(int i=0; i<5; i++){
                    for(int j=0; j<5; j++){
                        if(grid[i][j]==strs[k].charAt(0)){
                            find_index[k][0]=i;
                            find_index[k][1]=j;
                        }
                            
                    }
                }
            }
            // 움직였을 때의 값들
            int move_first_row;
            int move_first_col;
            int move_second_row;
            int move_second_col;
            
            //같은 row?
            if(find_index[0][0]==find_index[1][0]){
                move_first_row = find_index[0][0];
                move_first_col = find_index[0][1]+1;
                move_second_row = find_index[1][0];
                move_second_col = find_index[1][1]+1;
                if(move_first_col==5){
                    move_first_col=0;
                }
                if(move_second_col==5){
                    move_second_col=0;
                }
                result.append(grid[move_first_row][move_first_col]);
                result.append(grid[move_second_row][move_second_col]);
            }

            //같은 col?
            else if(find_index[0][1]==find_index[1][1]){
                move_first_row = find_index[0][0]+1;
                move_first_col = find_index[0][1];
                move_second_row = find_index[1][0]+1;
                move_second_col = find_index[1][1];
                if(move_first_row==5){
                    move_first_row=0;
                }
                if(move_second_row==5){
                    move_second_row=0;
                }
                result.append(grid[move_first_row][move_first_col]);
                result.append(grid[move_second_row][move_second_col]);
            }

            // 둘 다 no?
            else{

                move_first_row = find_index[0][0];
                move_first_col = find_index[1][1];
                move_second_row = find_index[1][0];
                move_second_col = find_index[0][1];

                result.append(grid[move_first_row][move_first_col]);
                result.append(grid[move_second_row][move_second_col]);
            }

        }
        System.out.println(result.toString());
       
    }
}

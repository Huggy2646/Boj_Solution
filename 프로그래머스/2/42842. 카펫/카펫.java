
class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2];
        int totalNum = brown+yellow;
        for(int i=1; i<=totalNum; i++){
            if(totalNum%i==0){
                int row = totalNum/i;
                int col = i;
                if(brown==row*2+((col-2)*2)){
                    answer[0]=row;
                    answer[1]=col;
                    break;
                }
            }
        }
        return answer;
    }
}
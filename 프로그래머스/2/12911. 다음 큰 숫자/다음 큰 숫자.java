class Solution {
    public int solution(int n) {
        int answer = 0;
        String binN = Integer.toBinaryString(n);
        int cntone = Cnt(binN);
        
        while(true){
            if(cntone==Cnt(Integer.toBinaryString(++n)))
                break;
        }
        answer=n;
        return answer;
    }
    public int Cnt(String bin){
        int cnt=0;
        for(int i=0; i<bin.length(); i++){
            if(bin.charAt(i)=='1')
                cnt++;
        }
        return cnt;
    }
}
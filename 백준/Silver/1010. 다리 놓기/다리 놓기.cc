#include <iostream>
#include <vector>

using namespace std;
vector<int> v(30,0);



int main(){
    v[1]=1;
    v[2]=2;
    //Testcase Num
    int T;
    cin >> T;
    //Testcase Start
    long long  result;
    for(int t=0; t<T; t++){
        long long  result1=1;
        //input N,M
        long  N,M;
        cin >> N >> M;
        int k=1;
        // 조합공식으로 풀이
        for(int i=M; i>M-N; i--){
            result1*=i;
            result1/=k++;
        }

        cout << result1<<endl;
   
    }

    return 0;
}
#include <iostream>
#include <vector>

using namespace std;

//용액들 저장소
vector<int> liqs;

int main()
{
    int N;
    cin >> N;

    int l=0;
    int r=N-1;


    long min = 10000000000;
    //최소값이 나오는 index 저장
    pair<int,int>p;
    p = make_pair(0,N-1);
    
    //용액들 읽고 저장
    for(int i=0; i<N; i++){
        int liq=0;
        cin >> liq;
        liqs.push_back(liq);
    }

    
    while(true){
        if(l>=r)
            break;
        else{
            int k = abs(liqs[l]+liqs[r]);

            if(k<min){
                min=k;
                p.first=l;
                p.second=r;
            }

            if(liqs[l]+liqs[r]>0){
                r--;
            }
            else
                l++;
        }
        
    }

    cout << liqs[p.first]<< " "<< liqs[p.second];
    return 0;
}
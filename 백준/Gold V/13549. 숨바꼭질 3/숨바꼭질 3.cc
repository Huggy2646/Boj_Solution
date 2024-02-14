#include <iostream>
#include <queue>
using namespace std;

int dp[100001]={0}; // 방문 check, 방문x=0, 방문o=1
queue<pair<int,int>> q;//pair first: subin position, pair second: sec
int start,target; // start == 수빈의 좌표, target=수빈이 동생 좌표

int bfs(pair<int,int>node){
    int x = node.first;
    int sec = node.second;

    if(x==target){
        return sec;
    }
    else{
        //0<=x*2<=100000, dp check(방문 안 한곳만 ㄱㄱ)
        if(0<=x*2 && x*2<=100000 && dp[x*2]==0){
            q.push(make_pair(x*2,sec));
            dp[x*2]=1;
        }
        //0<=x-1<=100000, dp check(방문 안 한곳만 ㄱㄱ)
        if(0<=x-1 && x-1<=100000 && dp[x-1]==0){
            q.push(make_pair(x-1,sec+1));
            dp[x-1]=1;
        }
        //0<=x+1<=100000, dp check(방문 안 한곳만 ㄱㄱ)
        if(0<=x+1 && x+1<=100000 && dp[x+1]==0){
            q.push(make_pair(x+1,sec+1));
            dp[x+1]=1;
        }

    }
    return -1;
}

int main(){

    cin >> start >> target;

    //init
    // 수빈이 더 큰 포지션에 있으면 -1로만 가야지 최선임
    // 아니면 초기값(root)을 넣어주고 방문 체크함(dp값)
    if(target<start){
        cout << (start-target);
        return 0;
    }
    else{
         q.push(make_pair(start,0));
         dp[start]=1;
    }
       
    
    //bfs start
    while(true){
        pair<int,int> current_node = q.front();
        q.pop();
        int is_correct = bfs(current_node);
        if(is_correct!=-1){
            cout << is_correct;
            break;
        }
    }
    
    return 0;

}
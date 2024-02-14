#include <iostream>

#include <queue>
#include <stack>
using namespace std;

// dp value == pre_operation
// pre_operation == -1 : root node
// pre_operation == 0  : 방문 안함
// pre_operation == 1 : -1에서 온 node
// pre_operation == 2 : +1에서 온 node
// pre_operation == 3 : *2에서 온 node
int dp[1000000] = { 0 };
// piar first : current subin positon
// pair second first : sec
// piar first second : pre_oper
queue<pair<int, pair<int, int>>> q;
int start, target; // start: subin position, target: subin brother position

int bfs(int x, int sec, int oper) {
    if (x == target) {
        return x;
    }
    else {

        if (0 <= x - 1 && x - 1 <= 100000 && dp[x - 1] == 0) {
            q.push(make_pair(x - 1, make_pair(sec + 1, 1)));
        }
        if (0 <= x + 1 && x + 1 <= 100000 && dp[x + 1] == 0) {
            q.push(make_pair(x + 1, make_pair(sec + 1, 2)));
        }
        if (0 <= x * 2 && x * 2 <= 100000 && dp[x * 2] == 0) {
            q.push(make_pair(x * 2, make_pair(sec + 1, 3)));
        }

    }
    return -1;
}

int main() {
    cin >> start >> target;
    stack<int> s;
    //init
    // 수빈이 positon이 수빈이 동생보다 앞에 있는 경우 계속 -1하는 경우가 최선
    // 같은 경우도 그냥 가만히 있는 것이 최선임]
    // 둘 다 아니면 queue에 저장
    if (target <= start) {
        int distance = start - target;
        cout << distance << endl;
        for (int i = start; i >= target; i--) {
            cout << i << " ";
        }
        return 0;
    }
    else {
        q.push(make_pair(start, make_pair(0, -1)));
    }

    //bfs start
    while (true) {
        pair<int, pair<int, int>> node = q.front();
        q.pop();
        int x = node.first;
        int sec = node.second.first;
        int oper = node.second.second;
        if (dp[x] == 0) {
            dp[x] = oper;
        }
            

        int is_correct = bfs(x, sec, oper);
        if (is_correct != -1) {
            cout << sec << endl;
            while (true) {
                if (oper == 1) {
                    s.push(x);
                    x = x + 1;
                    oper = dp[x];
                }
                else if (oper == 2) {
                    s.push(x);
                    x = x - 1;
                    oper = dp[x];
                }
                else if (oper == 3) {
                    s.push(x);
                    x = x / 2;
                    oper = dp[x];


                }
                else if (oper == -1) {
                    s.push(x);
                    break;
                }
            }
            break;
        }

    }
    while (!(s.empty())) {
        cout << s.top() << " ";
        s.pop();
    }
    return 0;
}
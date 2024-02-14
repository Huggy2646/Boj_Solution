#include <iostream>
#include <queue>
#include <vector>

using namespace std;
int buffer = 0;

class Node {
public:
	int x;
	int level;
	int pre_l;
	string oper;
	Node(int x, int level,int pre_l, string oper) {
		this->x = x;
		this->level = level;
		this->pre_l = pre_l;
		this->oper = oper;
	}
};


vector<int> dp(100001, 0);

queue<Node> q;
int start, end_p;




int bfs(Node n,int pre_l, string oper) {
	int x = n.x;
	int level = n.level;

	if (x == end_p) {
		return level;
	}
	else {
		if (pre_l <= level) {
			if (oper == "+") {
				dp[x-1] = 1;
			}
			else if (oper == "-") {
				dp[x + 1] = 1;
			}
			else if (oper == "*") {
				dp[x / 2] = 1;
			}
		}
		//checking -1 moveing point is correct range and dp check and push queue
		if (0 <= x - 1 && x - 1 <= 100000 && dp[x - 1] == 0) {
				q.push(Node(x - 1, level + 1,level,"-"));
		}
		//checking +1 moveing point is correct range and dp check and push queue
		if (0 <= x + 1 && x + 1 <= 100000 && dp[x + 1] == 0) {
				q.push(Node(x + 1, level + 1 , level, "+"));
		}
		//checking *2 moveing point is correct range and dp check and push queue
		if (0 <= x * 2 && x * 2 <= 100000 && dp[x * 2] == 0) {
				q.push(Node(x * 2, level + 1, level, "*"));
		}

	}
	return -1;
}


int main() {
	cin >> start >> end_p;
	int count = 0;
	//init
	q.push(Node(start, 0, -1," "));
	dp[start] = 1;

	if (end_p <= start) {
		cout << start - end_p << endl;
		cout << 1;
		return 0;
	}
	while (true) {
		int l = bfs(q.front(),q.front().level,q.front().oper);

		q.pop();
		if (l != -1) {
			count++;
			while (!(q.empty())) {
				if (q.front().level == l) {
					if (q.front().x == end_p)
						count++;
				}
				q.pop();
			}
			cout << l << endl;
			break;
		}

	}
	cout << count;

	return 0;
}
#include <iostream>
#include <queue>
#include <vector>

using namespace std;


class Node {
public:
	int x;
	int level;
	Node(int x, int level) {
		this->x = x;
		this->level = level;
	}
};

vector<int> dp(100001, 0);
queue<Node> q;
int start, end_p;




int bfs(Node n) {
	int x = n.x;
	int level = n.level;

	if(x == end_p) {
		return level;
	}
	else {
		//checking -1 moveing point is correct range and dp check and push queue
		if (0 <= x - 1 && x - 1 <= 100000 && dp[x - 1] == 0) {
			dp[x - 1] = 1;
			q.push(Node(x - 1, level + 1));
		}
		//checking +1 moveing point is correct range and dp check and push queue
		if (0 <= x + 1 && x + 1 <= 100000 && dp[x + 1] == 0) {
			dp[x + 1] = 1;
			q.push(Node(x + 1, level + 1));
		}
		//checking *2 moveing point is correct range and dp check and push queue
		if (0 <= x *2 && x *2 <= 100000 && dp[x *2] == 0) {
			dp[x *2] = 1;
			q.push(Node(x * 2, level + 1));
		}
	}
	return -1;
}


int main() {
	cin >> start >> end_p;
	int count = 0;
	//init
	q.push(Node(start, 0));
	dp[start] = 1;

	while (true) {
		int l = bfs(q.front());
		if (l != -1) {

			cout << l;
			break;
		}
		q.pop();
	}

	return 0;
}
#include <iostream>
#include <vector>
#include <cmath>
#include <queue>
using namespace std;

vector <int>v;

vector <int>result;
queue<pair<int,pair<int,int>>> q;
int pre_depth=0;

void binary(int start,int end,int depth) {

	if (pre_depth != depth) {
		cout << "\n";
		pre_depth = depth;
	}

	if (end < start) {
		return;
	}
	int mid = (start + end) / 2;
	cout << v[mid]<<" ";
	depth++;
	//왼쪽
	q.push(make_pair(start, make_pair(mid - 1, depth)));
	//오른쪽
	q.push(make_pair(mid + 1, make_pair(end, depth)));

}

int main() {

	int level;
	cin >> level;
	int size = pow(2, level) - 1;

	int start = 0;
	int end = size - 1;


	for (int i = 0; i < size; i++) {
		int value = 0;
		cin >> value;
		v.push_back(value);

	}
	//init
	q.push(make_pair(start, make_pair(end,0)));

	int dep_buffer = 0;
	while (!q.empty()) {
		pair<int, pair<int,int>> buffer = q.front();
		binary(buffer.first, buffer.second.first, buffer.second.second);
		q.pop();
	}
	
	return 0;

}
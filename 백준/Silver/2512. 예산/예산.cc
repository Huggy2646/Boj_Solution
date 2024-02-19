#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int main() {
	int N = 0;
	int total;
	int max=0;
	cin >> N;
	vector<int> bs;
	for (int n = 0; n < N; n++) {
		int b;
		cin >> b;
		bs.push_back(b);
	}

	cin >> total;
	sort(bs.begin(), bs.end());

	int start = 0;
	int end = bs[N-1];
	int mid=0;
	while (true) {
		int buffer = 0;
		mid = (start + end) / 2;
		if (end<start) {
			break;
		}
		for (int b : bs) {
			buffer += b < mid ? b : mid;
		}

		if (buffer < total) {
			max = max < mid ? mid : max;
			start = mid + 1;
		}
		else if(buffer == total) {
			max = mid;
			break;
		}
		else {
			end = mid - 1;
		}
	}
	cout << max;
}
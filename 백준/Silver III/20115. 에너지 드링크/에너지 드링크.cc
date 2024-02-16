#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
	int N = 0;
	cin >> N;
	vector<double> liqs;
	for (int i = 0; i < N; i++) {
		double liq;
		cin >> liq;
		liqs.push_back(liq);
	}

	sort(liqs.begin(), liqs.end());
	for (int i = 0; i < N-1; i++) {
		
		liqs[N - 1] += liqs[i] / 2;
	}
	cout << liqs[N - 1];
}
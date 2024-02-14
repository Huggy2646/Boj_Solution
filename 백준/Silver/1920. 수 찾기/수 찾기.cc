#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
	int a;
	int b;
	vector<int> a_s;
	vector<int> b_s;
	cin >> a;
	for (int i = 0; i < a; i++) {
		int buf;
		cin >> buf;
		a_s.push_back(buf);
	}
	sort(a_s.begin(), a_s.end());
	cin >> b;
	for (int i = 0; i < b; i++) {
		int buf;
		cin >> buf;
		b_s.push_back(buf);
	}
	for (int i = 0; i < b; i++) {
		cout << binary_search(a_s.begin(), a_s.end(), b_s[i]) << '\n';
	}
	
	return 0;
}
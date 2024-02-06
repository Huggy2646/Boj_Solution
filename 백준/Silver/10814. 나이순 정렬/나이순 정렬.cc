#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

bool compare(pair<int, string> p1, pair<int, string> p2)
{
	int a = p1.first, b = p2.first;
	return a < b;
}
int main(void)
{
	vector<pair<int, string>> v;
	int N = 0, age = 0;
	string s;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		cin >> age >> s;
		v.push_back(make_pair(age, s));
	}
	stable_sort(v.begin(), v.end(), compare);
	for (int i = 0; i < v.size(); i++)
	{
		cout << v[i].first << ' ' << v[i].second << '\n';
	}
}
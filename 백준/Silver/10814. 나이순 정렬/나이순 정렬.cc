#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

bool compare(pair<int, string> front, pair<int, string> back)
{
	int a = front.first;
	int b = back.first;
	return a < b;
}

int main(void) {
	vector<pair<int, string>> person;
	int N=0,age=0;
	string name;
	cin >> N;
	
	for (int i = 0; i < N; i++) {
		cin >> age >> name;
		person.push_back(make_pair(age, name));
	}

	stable_sort(person.begin(), person.end(), compare);
	for (int i = 0; i < person.size(); i++) {
		cout << person[i].first << ' ' << person[i].second << '\n';
	}
	return 0;
}
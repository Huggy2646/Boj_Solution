#define _CRT_SECURE_NO_DEPRECATE
#include<iostream>
#include<vector>
using namespace std;
int arr[201][201][201] = {};
int dp(int w, int l, int h) {
	int w_min = 0;
	int l_min = 0;
	int h_min = 0;
	
	if (arr[w][l][h] != 0) {
		return arr[w][l][h];
	}
	if (w == l && l == h) {
		arr[w][l][h] = 1;
		return 1;
	}
	if (w == 1 || l == 1 || h == 1) {
		int t;
		if (arr[w][l][h] == 0) {
			t = w * l * h;
			arr[w][l][h] = t;
			arr[w][h][l] = t;
			arr[h][w][l] = t;
			arr[h][l][w] = t;
			arr[l][w][h] = t;
			arr[l][h][w] = t;
			return arr[w][l][h];
		}
	}
	//w
	for (int i = w / 2; i > 0; i--) {
		int w_1 = w - i;
		int w_2 = i;
		int buff = dp(w_1, l, h) + dp(w_2, l, h);
		if (w_min == 0 || w_min > buff) {
			w_min = buff;
		}
	}
	//l
	for (int i = l / 2; i > 0; i--) {
		int l_1 = l - i;
		int l_2 = i;
		int buff = dp(w, l_1, h) + dp(w, l_2, h);
		if (l_min == 0 || l_min > buff) {
			l_min = buff;
		}

	}
	//h
	for (int i = h / 2; i > 0; i--) {
		int h_1 = h - i;
		int h_2 = i;
			int buff = dp(w, l, h_1) + dp(w, l, h_2);
			if (h_min == 0 || h_min > buff) {
				h_min = buff;
			}
	}
	//compare
	int min = 0;
	if (w_min > l_min) {
		if (l_min > h_min) {
			min = h_min;
		}
		else {
			min = l_min;
		}
	}
	else {
		if (w_min > h_min) {
			min = h_min;
		}

		else {
			min = w_min;
		}
	}
	//save
	arr[w][l][h] = min;
	arr[w][h][l] = min;
	arr[h][w][l] = min;
	arr[h][l][w] = min;
	arr[l][w][h] = min;
	arr[l][h][w] = min;
	return min;
}
int main() {
	int cases;
	cin >> cases;
	for (int i = 0; i < cases; i++) {
		int w, l, h;
		cin >> w >> l >> h;
		cout << dp(w, l, h) << endl;
	}
	return 0;
}
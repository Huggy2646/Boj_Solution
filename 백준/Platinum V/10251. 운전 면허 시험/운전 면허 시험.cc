#include <iostream>
#include <vector>
#include <algorithm>
#include <string.h>
using namespace std;

int main() {
	
	int case_num;
	int grid_size_r=0;
	int grid_size_c=0;
	int distance=0;
	int goal_cost=0;
	cin >> case_num;
	while (case_num--) {
		cin >> grid_size_r;
		cin >> grid_size_c;
		cin >> distance;
		cin >> goal_cost;

		vector<vector<int>> cost_r(grid_size_r, vector<int>(grid_size_c-1, 0));
		vector<vector<int>> cost_d(grid_size_r-1, vector<int>(grid_size_c, 0));
		// 0:down, 1:right
		int down = 0;
		int right = 1;
		int dp [100][100][201][2];
		memset(dp, 1000000, sizeof(dp));
		dp[0][0][0][0] = 0;
		dp[0][0][0][1] = 0;
		
		for (int i = 0; i < grid_size_r + grid_size_c + 1; i++) {
			dp[0][0][i][0] = 0;
			dp[0][0][i][1] = 0;
		}

		for (int i = 0; i < grid_size_r; i++) {
			for (int j = 0; j < grid_size_c - 1; j++) {
				int cost;
				cin >> cost;
				cost_r[i][j] = cost;
				
			}
			
		}
		for (int i = 0; i < grid_size_r - 1; i++) {
			for (int j = 0; j < grid_size_c; j++) {
				int cost;
				cin >> cost;
				cost_d[i][j] = cost;
				
			}
			
		}
		for (int i = 0; i < grid_size_r; i++) {
			for (int j = 0; j < grid_size_c; j++) {
				for (int t = 0; t < grid_size_r + grid_size_c; t++) {
					if (j + 1 < grid_size_c) { //제일 오른쪽은 더 이상 계산할 것이 없어서 조건문을 넣음
						//오른쪽-오른쪽으로 갔을 때
						dp[i][j + 1][t][right] = min(dp[i][j + 1][t][right], dp[i][j][t][right] + cost_r[i][j]);
						//아래-오른쪽
						dp[i][j + 1][t + 1][right] = min(dp[i][j + 1][t + 1][right], dp[i][j][t][down] + cost_r[i][j]);
					}
					if (i + 1 < grid_size_r) { // 제일 아래쪽은 더 이상 계산할 것이 없어서 조건문을 넣음
						//아래-아래으로 갔을 때
						dp[i + 1][j][t][down] = min(dp[i + 1][j][t][down], dp[i][j][t][down] + cost_d[i][j]);
						//오른-아래
						dp[i + 1][j][t + 1][down] = min(dp[i + 1][j][t + 1][down], dp[i][j][t][right] + cost_d[i][j]);
					}

				}

			}

		}

		int min_t = grid_size_r + grid_size_c + 1;
		for (int i = 0; i < grid_size_r + grid_size_c + 1; ++i) {
			if (dp[grid_size_r - 1][grid_size_c - 1][i][down] <= goal_cost || dp[grid_size_r - 1][grid_size_c - 1][i][right] <= goal_cost)
				min_t = min(min_t, i);
		}

		if (min_t == grid_size_r + grid_size_c+1)
			cout << -1 << endl;
		else
			cout << min_t + (grid_size_r + grid_size_c - 2) * distance << endl;
	}
	

	return 0;
}



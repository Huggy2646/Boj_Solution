#include <iostream>
#include <vector>
using namespace std;

const int h = 8;
const int w = 8;


int main() {
	int M, N;
	cin >> N >> M;
	vector<vector<char>> grid(N, vector<char>(M));

	//data read
	for (int i = 0; i < N; i++) {
		string buf;
		cin >> buf;
		for (int j = 0; j < buf.size(); j++) {
			grid[i][j] = buf.at(j);
		}
	}
	int min = 2147483647;
	for (int i = 0; i < N - 7; i++) {
		for (int j = 0; j < M - 7; j++) {
			int wbwb = 0;
			int bwbw = 0;
			for (int k = i; k < i + 8; k++) {
				for (int l = j; l < j + 8; l++) {
					//모든 경우 수를 다 대입하여 카운트 해야됨
					/*
						ex) wbwbwbwbwb ...(1),(2)        => row: 홀수 + col 홀수 => w , row: 홀수 + col 짝수 => b
							bwbwbwbwbw ...(3),(4)		 => row: 짝수 + col 홀수 => b , row: 짝수 + col 짝수 => w
							이렇게 바꿔서 최적을 내야 하는 상황과
							bwbwbwbwbw ... (1),(2)		 => row: 홀수 + col 홀수 => b , row: 홀수 + col 짝수 => w
							wbwbwbwbwb ...(3),(4)		 => row: 짝수 + col 홀수 => w , row: 짝수 + col 짝수 => b
							상황을 동시에 카운트
								(1) row(k)가 홀수 번째이고 col(l)홀수 이고 wbwb일때 w가 아니면 바꾸는 카운트 ++
								   동시에
								   row(k)가 홀수 번째 이고 col(l)홀수 이고 bwbw일때 b가 아니면 바꾸는 카운트 ++

								(2) row(k)가 홀수 번째이고 col(l)짝수 이고 wbwb일때 b가 아니면 바꾸는 카운트 ++
								   동시에
								   row(k)가 홀수 번째 이고 col(l)짝수 이고 bwbw일때 w가 아니면 바꾸는 카운트 ++
								.
								.
								.
								.
								해서 wbwb vs bwbw해서 작은 수를 global한 min 값이랑 비교..!

					*/
					if (k % 2 != 0) {
						if (l % 2 != 0) {
							if (grid[k][l] != 'W')
								wbwb++;
							if (grid[k][l] != 'B')
								bwbw++;
						}
						if (l % 2 == 0) {
							if (grid[k][l] != 'B')
								wbwb++;
							if (grid[k][l] != 'W')
								bwbw++;
						}

					}
					else if (k % 2 == 0) {
						if (l % 2 != 0) {
							if (grid[k][l] != 'B')
								wbwb++;
							if (grid[k][l] != 'W')
								bwbw++;
						}
						if (l % 2 == 0) {
							if (grid[k][l] != 'W')
								wbwb++;
							if (grid[k][l] != 'B')
								bwbw++;
						}
					}

				}
			}
			int buffer = bwbw < wbwb ? bwbw : wbwb;
			min = buffer < min ? buffer : min;
		}

	}
	cout << min;
	return 0;
}
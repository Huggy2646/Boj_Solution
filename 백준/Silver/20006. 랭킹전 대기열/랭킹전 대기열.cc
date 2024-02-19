#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int m = 0;

class Room {
	public:
		int current_num=0;
		int min_level;
		int max_level;
		
		map<string, int> player;
		vector<string>keys;

		Room(int level, string id) {
			player.insert({ id, level });
			keys.push_back(id);
			min_level = level - 10;
			max_level = level + 10;
			current_num++;
		}
		void add_player(int level, string id) {
			player.insert({ id,level });
			keys.push_back(id);
			current_num++;
		}
};
int main() {
	int p;
	cin >> p;
	cin >> m;
	vector<Room> rooms;


	while (p--) {
		int level;
		string id;
		bool is_enter=false;
		cin >> level;
		cin >> id;
		if (rooms.size() == 0) {
			rooms.push_back(Room(level, id));
			continue;
		}
		for (Room &room : rooms) {
			if (room.current_num != m && room.min_level <= level && level <= room.max_level) {
				room.add_player(level, id);
				is_enter = true;
				break;
			}
			else {
				continue;
			}
		}
		if (!is_enter) {
			rooms.push_back(Room(level, id));
			is_enter = false;
		}

	}
	for (Room &room : rooms) {
		sort(room.keys.begin(), room.keys.end());
		if (room.current_num == m) {
			cout << "Started!" << "\n";
			for (auto i : room.keys) {
				cout << room.player[i] << " " << i << "\n";

			}
		}
		else {
			cout << "Waiting!" << "\n";
			for (auto i : room.keys) {
				cout << room.player[i] << " " << i << "\n";

			}
		}
	}


	return 0;
}
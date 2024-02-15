#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int main() {
    long long k, n;
    vector<long long> k_v;
    cin >> k >> n;
    for (long long i = 0; i < k; i++) {
        long long buf;
        cin >> buf;
        k_v.push_back(buf);
    }
    sort(k_v.begin(), k_v.end());
    long long max = k_v[k - 1];
    long long min = 1;
    long long result_len = 0;
    while (min <= max) {
        long long h = (max + min) / 2;
        long long buf = 0;
        for (int i = 0; i < k; i++) {
            buf += k_v[i] / h;
        }
        if (n <= buf) {
            if(result_len<h)
                result_len = h;
            min = h + 1;
        }
        else
            max = h - 1;
    }
    cout << result_len;
    return 0;
}
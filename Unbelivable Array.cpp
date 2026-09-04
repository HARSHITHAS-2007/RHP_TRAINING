#include <iostream>
#include <vector>
#include <map>
using namespace std;

int find(vector<int>& ld, int node) {
    if (ld[node] != node) {
        ld[node] = find(ld, ld[node]);
    }
    return ld[node];
}

void join(vector<int>& ld, int lt, int rt) {
    int ldlt = find(ld, lt);
    int ldrt = find(ld, rt);
    if (ldlt != ldrt) {
        ld[ldrt] = ldlt; // ldlt (leader of x) becomes the root of both
    }
}

int main() {
    // Fast I/O to avoid Time Limit Exceeded (TLE)
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for (int ctr = 1; ctr <= t; ctr++) {
        cout << "Case " << ctr << ":\n";
        int n, q;
        cin >> n >> q;
        vector<int> a(n + 1), ld(n + 1);
        map<int, int> vlm, lvm;

        for (int i = 1; i <= n; i++) {
            cin >> a[i];
            if (vlm.find(a[i]) == vlm.end()) {
                vlm[a[i]] = i;
                lvm[i] = a[i];
            }
            ld[i] = vlm[a[i]];
        }

        for (int i = 0; i < q; i++) {
            int qt;
            cin >> qt;
            if (qt == 1) {
                int x, y;
                cin >> x >> y;
                if (x == y) continue;
                if (vlm.find(x) == vlm.end()) continue;

                if (vlm.find(y) != vlm.end()) {
                    int xldr = find(ld, vlm[x]);
                    int yldr = find(ld, vlm[y]);

                    join(ld, xldr, yldr);

                    // Since xldr is now the leader of the merged set:
                    lvm.erase(yldr);      // Remove old y leader map
                    lvm[xldr] = y;        // Set xldr's new value to y

                    vlm.erase(x);         // x no longer exists
                    vlm[y] = xldr;        // y's leader is now xldr
                } else {
                    int xldr = find(ld, vlm[x]);
                    lvm[xldr] = y;
                    vlm.erase(x);
                    vlm[y] = xldr;
                }
            } else {
                int idx;
                cin >> idx;
                int uldr = find(ld, idx); // Fixed: Pass 'idx', not 'ld[idx]'
                cout << lvm[uldr] << "\n"; // Fixed: Use "\n" instead of endl for speed
            }
        }
    }
    return 0;
}

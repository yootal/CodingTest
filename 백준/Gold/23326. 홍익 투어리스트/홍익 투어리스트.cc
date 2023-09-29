#include <bits/stdc++.h>
using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  set<int> univ; 
  int N, Q, t, curr = 1;
  cin >> N >> Q;
  for (int i = 1; i <= N; i++) {
    cin >> t;
    if (t) univ.insert(i);
  }
  while (Q--) {
    cin >> t;
    switch (t) {
      case 1:
        cin >> t;
        if (univ.find(t) != univ.end())
          univ.erase(t);
        else
          univ.insert(t);
        break;

      case 2:
        cin >> t;
        curr = (curr + t - 1) % N + 1;
        break;

      case 3:
        if (univ.empty()) {
            cout << -1 << '\n';
        }
        else {
          auto it = univ.lower_bound(curr);
          if (it != univ.end())
            cout << *it - curr << '\n';
          else
            cout << N - curr + *univ.begin() << '\n';
        }
    }
  }
}
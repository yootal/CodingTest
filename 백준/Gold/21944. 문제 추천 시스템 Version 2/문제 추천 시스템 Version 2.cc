#include <bits/stdc++.h>
using namespace std;

string op;
int N, L, P, G, x;
pair<int, int> probLevel[100'002]; // 문제 (난이도, 분류) 저장
set<int> probByL[102];  // 난이도별 저장
set<int> probByGL[102][102];  // (분류, 난이도)별 저장

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N;
  // 입력받은 값 넣기
  while (N--) {
    cin >> P >> L >> G;
    probLevel[P] = {L, G};
    probByL[L].insert(P);
    probByGL[G][L].insert(P);
  }
  cin >> N;
  while (N--) {
    cin >> op;
    if (op == "recommend") {
      cin >> G >> x;
      if (x == 1) {
        // 최대 100에서부터 -> 가장 어려운 문제 출력
        for (int i = 100; i >= 0; i--) {
          if (probByGL[G][i].empty()) continue;
          cout << *(prev(probByGL[G][i].end())) << '\n';
          break;
        }
      } else {
        // 최소 0에서부터 -> 가장 쉬운 문제 출력
        for (int i = 0; i < 101; i++) {
          if (probByGL[G][i].empty()) continue;
          cout << *probByGL[G][i].begin() << '\n';
          break;
        }
      }
    }
    
    else if(op == "recommend2"){
      cin >> x;
        if (x == 1) {
          // 가장 어려운 문제
        for (int i = 100; i >= 0; i--) {
          if (probByL[i].empty()) continue;
          cout << *(prev(probByL[i].end())) << '\n';
          break;
        }
      } else {
        // 가장 쉬운 문제
        for (int i = 0; i < 101; i++) {
          if (probByL[i].empty()) continue;
          cout << *probByL[i].begin() << '\n';
          break;
        }
      }
    }

    else if(op == "recommend3"){
      cin >> x >> L;
      int ans = -1;
      if(x == 1){
        // L보다 난이도가 높거나 같은 문제중 가장 쉬운 문제
        for(int i = L; i < 101; i++){
          if(probByL[i].empty()) continue;
          ans = *probByL[i].begin();
          break;
        }
      }
      else{
        // L보다 난이도가 낮은 문제중 가장 어려운 문제
        for(int i = L-1; i >= 0; i--){
          if(probByL[i].empty()) continue;
          ans = *(prev(probByL[i].end()));
          break;
        }
      }
      cout << ans << '\n';
    }
    
    else if (op == "add") {
      // 문제 추가
      cin >> P >> L >> G;
      probLevel[P] = {L, G};
      probByL[L].insert(P);
      probByGL[G][L].insert(P);
    }
    
    else if (op == "solved") {
      // 문제 해결 시 지워 줌
      cin >> P;
      tie(L, G) = probLevel[P];
      probByL[L].erase(P);
      probByGL[G][L].erase(P);
    }
  }
}
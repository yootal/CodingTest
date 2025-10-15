import java.util.*;

class Solution {
    static int[] weak;
    static int[] dist;
    static int[] check;
    static int[] w;
    static int m;
    static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.weak = weak;
        this.dist = dist;
        Arrays.sort(dist);
        m = weak.length;
        w = new int[m * 2];
        check = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = weak[i];
            w[i + m] = weak[i] + n;
        }
        solve(dist.length - 1, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static void solve(int idx, int cnt) {
        if (cnt == m) {
            answer = Math.min(answer, dist.length - idx - 1);
            return;
        }
        if (idx == -1) return;
        int d = dist[idx];
        for (int i = 0; i < m; i++) {
            if (check[i % m] != 0) continue;
            int nxtCnt = 0;
            List<Integer> record = new ArrayList<>();
            for (int j = i; j < w.length && w[j] <= w[i] + d; j++) {
                int idxWeak = j % m;
                if (check[idxWeak] == 0) {
                    nxtCnt++;
                }
                check[idxWeak]++;
                record.add(idxWeak);
            }
            if (nxtCnt > 0) solve(idx - 1, cnt + nxtCnt);
            for (int r : record) {
                check[r]--;
            }
        }
    }
}

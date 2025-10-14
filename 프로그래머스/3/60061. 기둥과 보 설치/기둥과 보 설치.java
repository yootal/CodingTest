import java.util.*;

class Solution {
    int n;
    boolean[][] pillar; // pillar[x][y]: (x,y)에서 위로 기둥
    boolean[][] beam;   // beam[x][y]  : (x,y)에서 오른쪽으로 보

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        // 안전하게 n+2 할당 (경계 체크 단순화)
        pillar = new boolean[n + 2][n + 2];
        beam   = new boolean[n + 2][n + 2];

        for (int[] cmd : build_frame) {
            int x = cmd[0], y = cmd[1], a = cmd[2], b = cmd[3];

            if (a == 0) { // 기둥
                if (b == 1) { // 설치
                    pillar[x][y] = true;
                    if (!isAllValid()) pillar[x][y] = false;
                } else { // 삭제
                    pillar[x][y] = false;
                    if (!isAllValid()) pillar[x][y] = true;
                }
            } else { // 보
                if (b == 1) { // 설치
                    beam[x][y] = true;
                    if (!isAllValid()) beam[x][y] = false;
                } else { // 삭제
                    beam[x][y] = false;
                    if (!isAllValid()) beam[x][y] = true;
                }
            }
        }

        List<int[]> out = new ArrayList<>();
        // 출력 규칙에 맞춰 스캔: x ∈ [0..n], y ∈ [0..n]
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y]) out.add(new int[]{x, y, 0});
                if (beam[x][y])   out.add(new int[]{x, y, 1});
            }
        }
        // x 오름차순, x 같으면 y 오름차순, x y 같으면 기둥(0) 먼저
        out.sort(Comparator
                .comparingInt((int[] r) -> r[0])
                .thenComparingInt(r -> r[1])
                .thenComparingInt(r -> r[2]));

        int[][] ans = new int[out.size()][3];
        for (int i = 0; i < out.size(); i++) ans[i] = out.get(i);
        return ans;
    }

    // 전체 구조물 유효성 검증
    private boolean isAllValid() {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (pillar[x][y] && !canPlacePillar(x, y)) return false;
                if (beam[x][y]   && !canPlaceBeam(x, y))   return false;
            }
        }
        return true;
    }

    // 기둥 설치 가능 조건:
    // 1) 바닥(y == 0) 위
    // 2) 아래에 기둥 존재 (pillar[x][y-1])
    // 3) 현재 좌표에 보의 오른쪽 끝(beam[x][y]) 위
    // 4) 현재 좌표의 왼쪽에 보의 왼쪽 끝(beam[x-1][y]) 위
    private boolean canPlacePillar(int x, int y) {
        if (y == 0) return true;
        if (y - 1 >= 0 && pillar[x][y - 1]) return true;
        if (beam[x][y]) return true;
        if (x - 1 >= 0 && beam[x - 1][y]) return true;
        return false;
    }

    // 보 설치 가능 조건:
    // 1) 왼쪽 끝 아래에 기둥 (pillar[x][y-1])
    // 2) 오른쪽 끝 아래에 기둥 (pillar[x+1][y-1])
    // 3) 양쪽 끝이 모두 다른 보와 연결 (beam[x-1][y] && beam[x+1][y])
    private boolean canPlaceBeam(int x, int y) {
        // 보는 (x,y)~(x+1,y)이므로 x+1 ≤ n 이어야 의미가 있음
        // 전수검증 루프 자체가 배열 경계를 보장하므로 여기서는 조건만 체크
        if (y - 1 >= 0 && pillar[x][y - 1]) return true;
        if (y - 1 >= 0 && x + 1 <= n && pillar[x + 1][y - 1]) return true;
        if (x - 1 >= 0 && x + 1 <= n && beam[x - 1][y] && beam[x + 1][y]) return true;
        return false;
    }
}

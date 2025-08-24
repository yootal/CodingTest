import java.util.*;
import java.io.*;

public class Main {
    static int N, M, maxHeight;
    static char[][] board;
    static int[][] island;
    static int[] dx1 = {-1, 0, 1, 0};
    static int[] dy1 = {0, 1, 0, -1};
    static int[] dx2 = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy2 = {-1, 0, 1, 1, 1, 0, -1, -1};
    static ArrayList<Integer>[] graph;
    static int[] height;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        island = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        int idx = 1; // 섬 번호
        boolean[][] vis = new boolean[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        // 1. 섬 번호 기록
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'x' && !vis[i][j]) {
                    vis[i][j] = true;
                    q.offer(new int[]{i, j, idx++});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        island[cur[0]][cur[1]] = cur[2];
                        for (int d = 0; d < 8; d++) {
                            int nx = cur[0] + dx2[d];
                            int ny = cur[1] + dy2[d];
                            if (limit(nx, ny) && !vis[nx][ny] && board[nx][ny] == 'x') {
                                vis[nx][ny] = true;
                                island[nx][ny] = cur[2];
                                q.offer(new int[]{nx, ny, cur[2]});
                            }
                        }
                    }
                }
            }
        }
        if (idx == 1) { // 섬 없으면 -1 끝
            System.out.println(-1);
        } else {
            boolean[] islandCheck = new boolean[idx]; // 포함되지 않는 섬 체크
            boolean[] islandVis = new boolean[idx];
            graph = new ArrayList[idx];
            for (int i = 0; i < idx; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] nearIslandCnt; // 만나는 다른 섬 카운트 -> 가장 많은게 부모 섬
            // 2. 탈출 여부랑 부모 섬 찾기
            // 탈출이 가능하다 -> BFS 해서 범위 밖으로 탈출
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int curIsland = island[i][j];
                    if (curIsland > 0 && !islandVis[curIsland]) {
                        islandVis[curIsland] = true;
                        vis = new boolean[N][M];
                        vis[i][j] = true;
                        q.clear();
                        q.offer(new int[]{i, j});
                        nearIslandCnt = new int[idx];
                        boolean flag = false;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nx = cur[0] + dx1[d];
                                int ny = cur[1] + dy1[d];
                                if (limit(nx, ny)) {
                                    if (!vis[nx][ny]) {
                                        vis[nx][ny] = true;
                                        if (island[nx][ny] == curIsland || island[nx][ny] == 0) {
                                            q.offer(new int[]{nx, ny});
                                        } else {
                                            // 바다도 현재섬도 아니면 카운트 기록
                                            nearIslandCnt[island[nx][ny]]++;
                                        }
                                    }
                                } else {
                                    // 속해있지 않다.. 다른 섬을 가지거나 혼자
                                    islandCheck[curIsland] = true;
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) break;
                        }
                        if (!flag) {
                            // 부모섬 찾아서 기록
                            int cnt = 0;
                            int parentIsland = -1;
                            for (int is = 1; is < idx; is++) {
                                if (nearIslandCnt[is] > cnt) {
                                    cnt = nearIslandCnt[is];
                                    parentIsland = is;
                                }
                            }
                            graph[parentIsland].add(curIsland);
                        }
                    }
                }
            }
            height = new int[idx];
            for (int i = 1; i < idx; i++) {
                if (islandCheck[i]) { // 탈출 가능한 섬 기준으로 자식 섬 높이 체크
                    dfs(i);
                }
            }
            int[] ans = new int[maxHeight + 1];
            for (int i = 1; i < idx; i++) {
                ans[height[i]]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int x : ans) {
                sb.append(x).append(" ");
            }
            System.out.print(sb);
        }
    }

    static boolean limit(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    static int dfs(int idx) {
        int temp = 0;
        if (graph[idx].isEmpty()) {
            height[idx] = 0;
            return 0;
        }
        for (int nxt : graph[idx]) {
            temp = Math.max(temp, dfs(nxt));
        }
        height[idx] = temp + 1;
        maxHeight = Math.max(maxHeight, height[idx]);
        return height[idx];
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] vis = new int[N][M];
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        int roomCnt = 0;
        int maxSize = 0;
        int linkSize = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (vis[i][j] == 0) {
                    int roomSize = 1;
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = ++roomCnt;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int d = 0; d < 4; d++) {
                            if ((board[cur[0]][cur[1]] & (1 << d)) == 0) {
                                int nx = cur[0] + dx[d];
                                int ny = cur[1] + dy[d];
                                if (nx >= 0 && nx < N && ny >= 0 && ny < M && vis[nx][ny] == 0) {
                                    vis[nx][ny] = vis[cur[0]][cur[1]];
                                    roomSize++;
                                    q.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, roomSize);
                    al.add(roomSize);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (vis[i][j] != vis[nx][ny]) {
                            linkSize = Math.max(linkSize, al.get(vis[i][j]) + al.get(vis[nx][ny]));
                        }
                    }
                }
            }
        }
        System.out.println(roomCnt);
        System.out.println(maxSize);
        System.out.println(linkSize);
    }
}
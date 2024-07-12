import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0)
                    al.add(new int[]{board[i][j], i, j});
            }
        }
        al.sort(Comparator.comparingInt(o -> o[0]));
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int[] arr : al) {
            q.offer(arr);
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int time = 0;
        int size = q.size();
        int cnt = 0;
        while (!q.isEmpty() && time < S) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[1] + dx[d];
                int ny = cur[2] + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                    board[nx][ny] = board[cur[1]][cur[2]];
                    q.offer(new int[]{board[nx][ny], nx, ny});
                }
            }
            cnt++;
            if (cnt == size) {
                time++;
                cnt = 0;
                size = q.size();
            }
        }
        System.out.println(board[X - 1][Y - 1]);
    }
}
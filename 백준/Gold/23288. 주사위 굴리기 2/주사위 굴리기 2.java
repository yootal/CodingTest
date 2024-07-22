import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;

    static class Dice {
        int direction = 0;
        int px = 0, py = 0;
        int top = 1, bottom = 6;
        int a = 2, b = 3, c = 5, d = 4;

        public void move() {
            int nx = px + dx[direction];
            int ny = py + dy[direction];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                direction = (direction + 2) % 4;
                nx = px + dx[direction];
                ny = py + dy[direction];
            }
            px = nx;
            py = ny;
            if (direction == 0) {
                int temp1 = d;
                int temp2 = b;
                b = top;
                d = bottom;
                top = temp1;
                bottom = temp2;
            } else if (direction == 1) {
                int temp1 = a;
                int temp2 = c;
                c = top;
                a = bottom;
                top = temp1;
                bottom = temp2;
            } else if (direction == 2) {
                int temp1 = b;
                int temp2 = d;
                d = top;
                b = bottom;
                top = temp1;
                bottom = temp2;
            } else {
                int temp1 = c;
                int temp2 = a;
                a = top;
                c = bottom;
                top = temp1;
                bottom = temp2;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int score = 0;
        Dice dice = new Dice();
        boolean[][] visited;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            dice.move();
            if (dice.bottom > board[dice.px][dice.py]) {
                dice.direction = (dice.direction + 1) % 4;
            } else if (dice.bottom < board[dice.px][dice.py]) {
                dice.direction--;
                if (dice.direction < 0) dice.direction += 4;
            }
            visited = new boolean[N][M];
            visited[dice.px][dice.py] = true;
            q.offer(new int[]{dice.px, dice.py});
            int value = board[dice.px][dice.py];
            int cnt = 1;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && board[nx][ny] == value) {
                        visited[nx][ny] = true;
                        cnt++;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            score += value * cnt;
        }
        System.out.println(score);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    static String end = "123456780";
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[3][3];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sb.append(board[i][j]);
            }
        }
        System.out.println(solve(sb));
    }

    static int solve(StringBuilder pos) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayDeque<StringBuilder> q = new ArrayDeque<>();
        map.put(pos.toString(), 0);
        q.offer(pos);
        while (!q.isEmpty()) {
            String cur = q.poll().toString();
            int cnt = map.get(cur);
            int cIdx = cur.indexOf('0');
            int x = cIdx / 3;
            int y = cIdx % 3;
            if (cur.equals(end)) {
                return cnt;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < 3 && ny < 3) {
                    char nc = cur.charAt(nx * 3 + ny);
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(cIdx, nc);
                    sb.setCharAt(nx * 3 + ny, '0');
                    if (!map.containsKey(sb.toString())) {
                        map.put(sb.toString(), cnt + 1);
                        q.offer(sb);
                    }
                }
            }
        }
        return -1;
    }
}

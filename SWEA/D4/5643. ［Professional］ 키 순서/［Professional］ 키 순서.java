import java.io.*;
import java.util.*;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            boolean[][] arr = new boolean[N + 1][N + 1]; 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = true; // 연결 표시
            }
            // i -> k, k -> j 가 연결 상태면 i -> j 가능 
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (arr[i][k] && arr[k][j]) {
                            arr[i][j] = true;
                        }
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] || arr[j][i])
                        cnt++;
                }
                if (cnt == N - 1)
                    ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
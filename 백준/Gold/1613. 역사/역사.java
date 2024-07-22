import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[N + 1][N + 1];
        int[][] arr2 = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr1[i], 500);
            Arrays.fill(arr2[i], 500);
            arr1[i][i] = 0;
            arr2[i][i] = 0;
        }
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr1[a][b] = 1;
            arr2[b][a] = 1;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr1[i][j] > arr1[i][k] + arr1[k][j]) {
                        arr1[i][j] = arr1[i][k] + arr1[k][j];
                    }
                    if (arr2[i][j] > arr2[i][k] + arr2[k][j]) {
                        arr2[i][j] = arr2[i][k] + arr2[k][j];
                    }
                }
            }
        }
        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = 0;
            if (arr1[a][b] != 500) {
                ans = -1;
            } else if (arr2[a][b] != 500) {
                ans = 1;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
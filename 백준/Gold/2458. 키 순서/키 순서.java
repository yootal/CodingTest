import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N + 1][N + 1]; // 인접 행렬에 기록
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// a < b
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true; // 연결 표시
		}
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
		System.out.println(ans);
	}

}
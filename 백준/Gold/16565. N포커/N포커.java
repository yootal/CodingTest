import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] C = new int[53][53];
		for (int i = 0; i < 53; i++) {
			for (int j = 0, end = Math.min(i, 52); j <= end; ++j) {
				if (j == 0 || j == i)
					C[i][j] = 1;
				// nCk = (n-1)C(k-1) + (n-1)C(k)
				else {
					C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % 10007;
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= 13 && N - 4 * i >= 0; i++) {
			// 포함 배제, 13가지 중 포카드 선택 * 나머지 가크 뽑기
			if (i % 2 == 1)
				// 홀수일때 +
				ans = (ans + C[13][i] * C[52 - 4 * i][N - 4 * i]) % 10007;
			else
				// 짝수일때 -
				ans = (((ans -  C[13][i] * C[52 - 4 * i][N - 4 * i]) % 10007) + 10007) % 10007;
		}

		System.out.println(ans);

	}
}
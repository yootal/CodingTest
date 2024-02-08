import java.io.*;
import java.util.*;

public class Main {
	static int flag;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int i = a; i < a + 10; i++) {
				for (int j = b; j < b + 10; j++) {
					paper[i][j] = 1;
				}
			}
		}
		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] != 0)
					paper[i][j] += paper[i-1][j];
			}
		}
		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				flag = 100;
				for (int k = j; k < 100; k++) {
					flag = Math.min(flag, paper[i][k]);
					if (flag == 0)
						break;
					ans = Math.max(ans, (k - j + 1) * flag);
				}
			}
		}
		System.out.println(ans);
	}
}
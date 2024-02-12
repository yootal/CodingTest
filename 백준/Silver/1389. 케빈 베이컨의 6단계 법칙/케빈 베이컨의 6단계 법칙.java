import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(arr[i], 10000000);
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int who = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int x : arr[i]) {
				sum += x;
			}
			if (min > sum) {
				min = sum;
				who = i + 1;
			}
		}
		System.out.println(who);
	}
}
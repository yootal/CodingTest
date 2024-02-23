import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N * 2];
		int[] check = new int[d + 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			sushi[i + N] = sushi[i];
		}
		int e = 0;
		int ans = 0;
		int cnt = 1;
		check[c] = 1;
		for (int s = 0; s < N * 2; s++) {
			while (e - s < k) {
				check[sushi[e]]++;
				if (check[sushi[e]] == 1) {
					cnt++;
				}
				e++;
			}
			ans = Math.max(ans, cnt);
			if (e == N * 2 - 1)
				break;
			check[sushi[s]]--;
			if (check[sushi[s]] == 0)
				cnt--;
		}
		System.out.println(ans);
	}
}
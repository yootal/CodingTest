import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean check[] = new boolean[1002];
		if (m != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				check[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= 1001; i++) {
			if (check[i])
				continue;
			for (int j = i; j <= 1001; j++) {
				if (check[j])
					continue;
				for (int k = j; k <= 1001; k++) {
					if (check[k])
						continue;
					ans = Math.min(ans, Math.abs(n - i * j * k));
				}
			}
		}
		System.out.println(ans);
	}
}
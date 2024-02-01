import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans = Integer.MAX_VALUE;
		int[] v1 = new int[n];
		int[] v2 = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v1[i] = a;
			v2[i] = b;
		}
		for (int j = 1; j < (1 << n); j++) {
			int t1 = 1;
			int t2 = 0;
			for (int k = 0; k < n; k++) {
				if (((1 << k) & j) > 0) {
					t1 *= v1[k];
					t2 += v2[k];
				}
			}
			ans = Math.min(Math.abs(t1 - t2), ans);
		}
		System.out.println(ans);
	}

}
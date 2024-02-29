import java.io.*;
import java.util.*;

public class Main {
	static long[] A, tmp;
	static long ans = 0;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new long[N + 1];
		tmp = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		merge(1, N);
		System.out.println(ans);
	}

	static void merge(int s, int e) {
		if (e - s < 1)
			return;
		int m = s + (e - s) / 2;
		merge(s, m);
		merge(m + 1, e);
		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int idx1 = s;
		int idx2 = m + 1;
		while (idx1 <= m && idx2 <= e) {
			if (tmp[idx1] > tmp[idx2]) {
				if (idx2 > k)
					ans += (idx2 - k);
				A[k] = tmp[idx2];
				k++;
				idx2++;
			} else {
				if (idx1 > k)
					ans += (idx1 - k);
				A[k] = tmp[idx1];
				k++;
				idx1++;
			}
		}
		while (idx1 <= m) {
			A[k] = tmp[idx1];
			k++;
			idx1++;
		}
		while (idx2 <= e) {
			A[k] = tmp[idx2];
			k++;
			idx2++;
		}
	}
}
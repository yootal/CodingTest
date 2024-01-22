import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int l = 0;
			int r = n - 1;
			int ans = 0;
			while (l <= r) {
				int mid = (l + r) / 2;
				if (a[mid] < x) {
					l = mid + 1;
				} else if (a[mid] > x) {
					r = mid - 1;
				} else {
					ans = 1;
					break;
				}
			}
			System.out.println(ans);
		}
	}
}
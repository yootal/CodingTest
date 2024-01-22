import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int l = 0;
		int r = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (l < arr[i])
				l = arr[i];
			r = r + arr[i];
		}
		while (l <= r) {
			int mid = (l + r) / 2;
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}
			if (sum != 0)
				cnt++;
			if (cnt > m)
				l = mid + 1;
			else
				r = mid - 1;
		}
		System.out.println(l);
	}
}
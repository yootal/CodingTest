import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int gimbap[] = new int[N];
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());
			if (len > K * 2)
				len -= K * 2;
			else if (K * 2 > len && K < len) {
				len -= K;
			} else {
				continue;
			}
			gimbap[i] = len;
		}
		int s = 1;
		int e = 1000000000;
		int ans = -1;
		while (s <= e) {
			int mid = (s + e) / 2;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (gimbap[i] != 0) {
					cnt += gimbap[i] / mid;
				}
			}
			if (cnt >= M) {
				ans = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
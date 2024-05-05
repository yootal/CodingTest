import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		int ans[] = new int[2];
		int pre = Integer.MAX_VALUE;
		int s = 0, e = N - 1;
		while (s < e) {
			int cur = num[s] + num[e];
			if (Math.abs(pre) > Math.abs(cur)) {
				ans[0] = num[s];
				ans[1] = num[e];
				pre = cur;
			}
			if (cur < 0)
				s++;
			else if (cur > 0)
				e--;
			else
				break;
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}
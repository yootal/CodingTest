import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int remain[] = new int[N * 2];
		boolean robot[] = new boolean[N];
		for (int i = 0; i < N * 2; i++) {
			remain[i] = Integer.parseInt(st.nextToken());
		}
		int zeroCnt = 0, turn = 0;
		while (true) {
			// 단계
			turn++;

			// 회전
			int temp = remain[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) remain[i] = remain[i - 1];
			remain[0] = temp;
			for (int i = N - 1; i > 0; i--) robot[i] = robot[i - 1];
			robot[0] = false;

			// 회전 후 빠지는 놈
			if (robot[N - 1]) robot[N - 1] = false;

			// 로봇 이동
			for (int i = N - 1; i > 0; i--) {
				if (remain[i] > 0 && !robot[i] && robot[i - 1]) {
					remain[i]--;
					if (remain[i] == 0) {
						zeroCnt++;
						if (zeroCnt >= K)
							break;
					}
					robot[i] = true;
					robot[i - 1] = false;
				}
			}
			if(zeroCnt >= K) break;

			// 이동 후 빠지는 놈
			if (robot[N - 1]) robot[N - 1] = false;

			// 로봇 올리기
			if (remain[0] > 0) {
				remain[0]--;
				if (remain[0] == 0) {
					zeroCnt++;
					if (zeroCnt >= K)
						break;
				}
				robot[0] = true;
			}
		}
		System.out.println(turn);
	}
}
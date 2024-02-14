import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N;
		long M;
		long maxCnt;
		long[] candyCnt = new long[100];
		for (int tc = 1; tc <= T; tc++) {
			stt = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stt.nextToken());
			M = Long.parseLong(stt.nextToken());
			stt = new StringTokenizer(br.readLine());
			maxCnt = 0;
			for (int i = 0; i < N; i++) {
				candyCnt[i] = Long.parseLong(stt.nextToken());
				maxCnt = Math.max(candyCnt[i], maxCnt);
			}
			long st = 1;
			long en = maxCnt;
			while (st <= en) {
				long value = 0;
				long mid = (st + en) / 2;
				for (int i = 0; i < N; i++) {
					value += candyCnt[i] / mid;
				}
				if (value >= M) {
					st = mid + 1;
				} else {
					en = mid - 1;
				}
			}
			sb.append("#").append(tc).append(" ").append(en).append("\n");
		}
		System.out.print(sb);
	}
}
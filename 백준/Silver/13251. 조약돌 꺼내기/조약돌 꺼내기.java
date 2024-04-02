import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		double totalCnt = 0; // 전체
		double[] cnt = new double[51]; // 갯수
		double[] pro = new double[51]; // 확률
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			cnt[i] = Double.parseDouble(st.nextToken());
			totalCnt += cnt[i];
		}
		double k = Double.parseDouble(br.readLine());
		double ans = 0;
		for (int i = 0; i < m; i++) {
			if (cnt[i] >= k) {
				pro[i] = 1;
				for (int j = 0; j < k; j++) {
					pro[i] *= (cnt[i] - j) / (totalCnt - j);
				}
				ans += pro[i];
			}
		}
		System.out.println(ans);
	}
}
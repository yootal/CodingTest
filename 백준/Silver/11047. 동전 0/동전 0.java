import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] D = new int[K + 1]; // 각 금액을 만드는 최소동전수(최적해)

		D[0] = 0; // 점화식으로 값을 구할 수 없는 대상 초기화!
		for (int i = 1; i <= K; i++) { // i : 금액
			int min = D[i - coin[0]] + 1; // 1원을 사용했을 경우로 임시 최적해
			for (int j = 1; j < N; j++) {
				if (i >= coin[j])
					min = Math.min(D[i - coin[j]] + 1, min);
				else
					break;
			}
			D[i] = min;
		}
		System.out.println(D[K]);
	}
}
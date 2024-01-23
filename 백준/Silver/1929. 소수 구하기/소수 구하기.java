import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		boolean[] num = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			if (!num[i]) {
				if (i >= M)
					sb.append(i).append("\n");
				for (long j = (long) i * i; j <= N; j += i) {
					if (j > N)
						break;
					num[(int) j] = true;
				}
			}
		}
		System.out.println(sb);
	}
}
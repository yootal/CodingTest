import java.io.*;
//import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int en = 1;
		int sum = 0;
		int ans = 0;
		for (int st = 1; st <= N; st++) {
			while (sum + en <= N) {
				sum += en;
				if (sum == N) ans++;
				en++;
			}
			if (en == N+1) break;
			sum -= st;
		}
		System.out.println(ans);
	}

}
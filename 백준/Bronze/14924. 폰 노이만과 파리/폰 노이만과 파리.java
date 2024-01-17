import java.io.*;
import java.util.*;

public class Main {
	static int[] A, tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int ans = (D / 2 / S) * T;
		System.out.println(ans);
	}
}
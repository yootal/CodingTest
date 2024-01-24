import java.io.*;
import java.util.*;

public class Main {
	static long min;
	static long max;
	static boolean[] squareCheck;
	static int ans = 0;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Long.parseLong(st.nextToken());
		max = Long.parseLong(st.nextToken());
		squareCheck = new boolean[(int) (max - min + 1)];
		for (long i = 2; i * i <= (long) max; i++) {
			long pow = i * i;
			long start = min / pow;
			if (min % pow != 0)
				start++;
			for (long j = start; pow * j <= max; j++) {
				squareCheck[(int) ((pow * j) - min)] = true;
			}
		}
		for (int i = 0; i <= (int) (max - min); i++) {
			if (!squareCheck[i])
				ans++;
		}
		System.out.println(ans);

	}

}
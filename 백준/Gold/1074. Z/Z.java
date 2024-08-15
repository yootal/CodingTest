import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stt.nextToken());
		int R = Integer.parseInt(stt.nextToken());
		int C = Integer.parseInt(stt.nextToken());
		System.out.println(Z(1 << N, R, C));
	}

	static int Z(int x, int R, int C) {
		if (x == 0)
			return 0;
		int half = 1 << (x - 1);
		if (R < half && C < half)
			return Z(x - 1, R, C);
		else if (R < half && C >= half)
			return half * half + Z(x - 1, R, C - half);
		else if (R >= half && C < half)
			return 2 * half * half + Z(x - 1, R - half, C);
		else
			return 3 * half * half + Z(x - 1, R - half, C - half);
	}
}
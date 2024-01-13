import java.io.*;

public class Main {
	static int n = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minA = 101;
		int minB = 101;
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < 4; i++) {
			n = Integer.parseInt(br.readLine());
			sumA += n;
			minA = Math.min(n, minA);
		}
		for (int i = 0; i < 2; i++) {
			n = Integer.parseInt(br.readLine());
			sumB += n;
			minB = Math.min(n, minB);
		}
		System.out.println(sumA - minA + sumB - minB);
	}

}
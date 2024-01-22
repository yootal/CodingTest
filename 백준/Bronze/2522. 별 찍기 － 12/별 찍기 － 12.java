import java.io.*;

public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < 2 * N - 1; i++) {
			for (int j = 0; j < Math.abs(N - i - 1); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < N - Math.abs(N - i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
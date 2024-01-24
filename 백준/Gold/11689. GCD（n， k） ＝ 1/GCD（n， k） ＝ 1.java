import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long ans = n;
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				ans = ans - ans / i;
				while (n % i == 0) {
					n /= i;
				}
			}
		}
		if (n > 1)
			ans = ans - ans / n;
		System.out.println(ans);
	}
}
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		String sNum = br.readLine();
		for (int i = 0; i < N; i++) {
			ans += Character.getNumericValue(sNum.charAt(i));
		}
		sb.append(ans);
		System.out.println(sb);
	}

}
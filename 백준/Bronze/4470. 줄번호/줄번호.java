import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append(i).append(". ").append(br.readLine()).append("\n");
		}
		System.out.print(sb);
	}
}
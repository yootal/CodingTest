import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Integer.compare(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
	}
}
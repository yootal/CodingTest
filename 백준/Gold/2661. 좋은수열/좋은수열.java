import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve("");
    }

    static void solve(String temp) {
        if (temp.length() == N) {
            System.out.println(temp);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (check(temp + i)) solve(temp + i);
        }
    }

    static boolean check(String temp) {
        for (int i = 1; i <= temp.length() / 2; i++) {
            String F = temp.substring(temp.length() - i * 2, temp.length() - i);
            String B = temp.substring(temp.length() - i);
            if (F.equals(B)) return false;
        }
        return true;
    }
}
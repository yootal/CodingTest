import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(0);
        solve(0);
        int total = 1;
        for (int i = 0; i < N; i++) {
            total *= 2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(total - 1).append("\n");
        for (int x : list) {
            sb.append(x).append("\n");
        }
        System.out.print(sb);
    }

    static void solve(int cnt) {
        if (cnt == N) {
            return;
        }
        int last = list.get(list.size() - 1);
        list.set(list.size() - 1, last + 1);
        list.addAll(new ArrayList<>(list));
        solve(cnt + 1);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static long P, Q;
    static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        System.out.println(solve(N));
    }

    static long solve(long idx) {
        if (map.containsKey(idx)) return map.get(idx);
        long value = solve(idx / P) + solve(idx / Q);
        map.put(idx, value);
        return value;
    }
}
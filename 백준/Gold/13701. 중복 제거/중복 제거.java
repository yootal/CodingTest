import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = 33554432;
        BitSet bitSet = new BitSet(size);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if (!bitSet.get(x)) {
                bitSet.set(x);
                sb.append(x).append(" ");
            }
        }
        System.out.print(sb);
    }
}
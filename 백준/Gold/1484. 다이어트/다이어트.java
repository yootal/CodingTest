import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int e = 1;
        for (int s = 1; s <= 100000; s++) {
            while (e * e - s * s < G) {
                e++;
            }
            if (e * e - s * s == G) {
                sb.append(e).append("\n");
            }
        }
        System.out.print(sb.length() == 0 ? -1 : sb);
    }
}
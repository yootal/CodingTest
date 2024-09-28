import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] check = {'Z', 'X', 'G', 'H', 'T', 'R', 'F', 'S', 'I', 'O'};
        String[] num = {"ZERO", "SIX", "EIGHT", "THREE", "TWO", "FOUR", "FIVE", "SEVEN", "NINE", "ONE"};
        int[] number = {0, 6, 8, 3, 2, 4, 5, 7, 9, 1};
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= N; tc++) {
            String row = br.readLine();
            boolean[] vis = new boolean[row.length()];
            ArrayList<Integer> al = new ArrayList<>();
            while (true) {
                boolean flag = false;
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < row.length(); k++) {
                        char cur = row.charAt(k);
                        if (!vis[k] && cur == check[j]) {
                            flag = true;
                            for (int l = 0; l < num[j].length(); l++) {
                                for (int m = 0; m < row.length(); m++) {
                                    if (!vis[m] && row.charAt(m) == num[j].charAt(l)) {
                                        vis[m] = true;
                                        break;
                                    }
                                }
                            }
                            al.add(number[j]);
                        }
                    }
                }
                if (!flag)
                    break;
            }
            sb.append("Case #").append(tc).append(": ");
            Collections.sort(al);
            for (int v : al) {
                sb.append(v);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
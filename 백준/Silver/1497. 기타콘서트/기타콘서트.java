import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] state = new long[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String temp = st.nextToken();
            long mask = 0;
            for (int j = 0; j < M; j++) {
                if (temp.charAt(j) == 'Y') {
                    mask |= (1L << j);
                }
            }
            state[i] = mask;
        }
        int maxSongs = -1;
        int minGuitars = Integer.MAX_VALUE;
        for (int comb = 1; comb < (1 << N); comb++) {
            long songMask = 0;
            int guitarNum = 0;
            for (int i = 0; i < N; i++) {
                if ((comb & (1 << i)) != 0) {
                    songMask |= state[i];
                    guitarNum++;
                }
            }
            int songNum = bitCount(songMask);
            if (songNum > maxSongs) {
                maxSongs = songNum;
                minGuitars = guitarNum;
            } else if (songNum == maxSongs && guitarNum < minGuitars) {
                minGuitars = guitarNum;
            }
        }
        if (maxSongs == 0) {
            System.out.println(-1);
        } else {
            System.out.println(minGuitars);
        }
    }

    static int bitCount(long x) {
        int ret = 0;
        while (x > 0) {
            ret += (int) (x & 1);
            x >>= 1;
        }
        return ret;
    }
}
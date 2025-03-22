import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long v = Long.parseLong(br.readLine()) % 7;
        if (v == 0 || v == 2) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}

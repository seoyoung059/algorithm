import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < i + 1 || 2 * (n - 1) - i < j)
                    sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < 2 * n; j++) {
                if (j < i + 1 || 2 * (n - 1) - i < j)
                    sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

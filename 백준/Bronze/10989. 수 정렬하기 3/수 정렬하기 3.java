import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[10001];

            for (int i = 0; i < n; i++) {
                arr[Integer.parseInt(br.readLine())] ++;
            }

            for (int i = 0; i < 10001; i++) {
                while (arr[i]-- > 0){
                    sb.append(i);
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
}
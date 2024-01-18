
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2000001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())+1000000] = 1;
        }

        for (int i = 0; i < 2000001; i++) {
            if (arr[i]==1){
                sb.append(i-1000000);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
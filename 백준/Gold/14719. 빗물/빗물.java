import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[w][2];

        int max;
        st = new StringTokenizer(br.readLine());
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[0][1] = 0;
        max = arr[0][0];
        for (int i = 1; i < w; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = max;
            max = Math.max(max,arr[i][0]);
        }

        int sum = 0;
        max = arr[w-1][0];
        for (int i = w-2; i >= 0; i--) {
            sum+=Math.max(0, Math.min(arr[i][1],max)-arr[i][0]);
            max = Math.max(arr[i][0], max);
        }
        System.out.println(sum);
    }
}
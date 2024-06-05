import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int d, n;

    static int lower_bound(int[] oven, int start, int dough) {
        int end = d, mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (oven[mid] < dough) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[] oven = new int[d+1];
        st = new StringTokenizer(br.readLine());
        oven[d] = Integer.MAX_VALUE;
        for (int i = d - 1; i >= 0; i--) {
            oven[i] = Math.min(Integer.parseInt(st.nextToken()), oven[i+1]);
        }

//        System.out.println(Arrays.toString(oven));

        int[] dough = new int[n];
        int start = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dough[i] = Integer.parseInt(st.nextToken());
            start = lower_bound(oven, start+1, dough[i]);
//            System.out.println(start);
        }

        System.out.println(d-start);
    }
}
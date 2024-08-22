import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;

    static int count(int minVal) {
        int cnt = 1, prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= minVal) {
                cnt++;
                prev = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int start = 0, end = arr[n-1]-arr[0]+1, mid;
        int tmp;
        while(start < end) {
            mid = (start + end)/2;

            if(count(mid) < c) end = mid;
            else start = mid + 1;
        }

        System.out.println(start - 1);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    static int[] count(int m) {
        int cnt = 1; int prev = arr[0];
        int tmp = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-prev >= m) {
                cnt++;
                tmp = Math.min(tmp, arr[i]-prev);
                prev = arr[i];
            }
        }
        return new int[] {cnt, tmp};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int s = 1, e = arr[n-1]-arr[0], m = (s+e)/2;
        int[] tmp; int answer = 0;
        while(s <= e){
            m = (s+e)/2;
            tmp = count(m);
            if(tmp[0] >= c){
                s = m+1;
                answer = Math.max(answer, tmp[1]);
            }
            else {
                e = m-1;
            }
        }
        System.out.println(answer);
    }
}
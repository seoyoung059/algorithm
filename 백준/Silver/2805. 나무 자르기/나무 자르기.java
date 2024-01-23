import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static long getTree(long mid, long[] arr){
        long sum = 0;
        for (long tree: arr){
            sum+=(tree>mid)?(tree-mid):0L;
        }
        return sum;
    }
    private static long solution(long[] arr, int n, long m) {
        Arrays.sort(arr);
        long start = 0L;
        long end = arr[n-1];
        long mid;

        while(start<=end){
            mid = (start+end)/2;
            if(getTree(mid,arr) < m){
                end = mid-1;
            }
            else start = mid+1;
        }
        return end;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(arr,n,m));
    }
}

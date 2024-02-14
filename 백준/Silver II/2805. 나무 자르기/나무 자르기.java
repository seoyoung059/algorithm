import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//
//    private static long getTree(long mid, long[] arr){
//        long sum = 0;
//        for (long tree: arr){
//            sum+=(tree>mid)?(tree-mid):0L;
//        }
//        return sum;
//    }
//    private static long solution(long[] arr, int n, long m) {
//        Arrays.sort(arr);
//        long start = 0L;
//        long end = arr[n-1]+1;
//        long mid;
//
//        while(start<end){
//            mid = (start+end)/2;
//            if(getTree(mid,arr) < m){
//                end = mid;
//            }
//            else start = mid+1;
//        }
//        return end;
//    }
//    public static void main(String[] args) throws IOException {
//        st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        long m = Integer.parseInt(st.nextToken());
//
//        long[] arr = new long[n];
//        st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//        System.out.println(solution(arr,n,m));
//    }
//}

    static int[] trees;
    static int n;
    static int m;
    static boolean cutTree(int height) {
        long tmp = 0;
        for(int i=n-1; i>=0; i--) {
            tmp+=Math.max(0,trees[i]-height);
            if(tmp >= m) return true;
        }
//        if(tmp >= m) return true;
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int start = 0; int end = trees[n-1]; int mid = (start+end)/2;
        while(start<=end) {
            mid = (start+end)/2;
            if(cutTree(mid)) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(end);
    }

}
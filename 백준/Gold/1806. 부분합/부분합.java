import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, s;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        int left=1; int answer = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        arr[0] =0;
        for (int i = 1; i < n+1; i++) {
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());

            while(arr[i]-arr[left]>=s){
                left++;
            }
            if(arr[i]-arr[left-1]>=s){
//                System.out.println(i+" "+(i-left));
                answer = Math.min(answer, i-left+1);
            }
        }
        if(answer<Integer.MAX_VALUE)
            System.out.println(answer);
        else System.out.println(0);
    }
}
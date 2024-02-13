import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean isPrime(int n){
        for (int i = 2; i * i<= n ; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    static int[] prime(int n){
        int[] arr = new int[n];
        int cnt = 1;
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) {
                arr[cnt] = i;
                cnt++;
            }
        }
        arr[0] = cnt;
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = prime(n);
        int answer = 0;
        if(n>=2) {
            int sum = arr[1];
            int cnt = arr[0];
            int left = 1;
            int right = 1;
            while (left < cnt) {
                while (right < cnt - 1 && sum < n) {
                    sum += arr[++right];
                }
                if (sum == n) {
                    answer++;
                }
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left, right, mid;
        for (int idx = 0; idx < n; idx++) {
//            System.out.println(arr[idx]);
            for (int i = 0; i < n; i++) {
                if(idx==i) continue;
                left = i+1;
                right = n-1;
//                System.out.println(arr[i]);
                while (left < right) {
                    mid = (left + right) / 2;
//                    System.out.println(arr[mid]);
                    if (arr[mid]+arr[i] < arr[idx]) left = mid+1;
                    else right = mid;
                }
                if (arr[i]+arr[right] == arr[idx] && idx!=right) {
                    cnt++;
                    break;
                }

                if (right+1 < n && arr[i]+arr[right+1] == arr[idx] && idx!=right+1) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
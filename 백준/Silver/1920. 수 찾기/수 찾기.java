import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    private static void find(int m, int[] nArr) {
        int start = 0;
        int end = nArr.length-1;
        int mid;

        while (start <= end) {
            mid = (start+end)/2;
            if (nArr[mid]==m) {
                sb.append("1\n");
                return;
            }
            else if (nArr[mid] > m) {
                end = mid-1;
            }
            else if (nArr[mid] < m) {
                start = mid+1;
            }
        }
        sb.append("0\n");
        return;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] nStrArr = br.readLine().split(" ");
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(nStrArr[i]);
        }
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        String[] mStrArr = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            find(Integer.parseInt(mStrArr[i]),nArr);
        }
        System.out.println(sb.toString());
    }
}

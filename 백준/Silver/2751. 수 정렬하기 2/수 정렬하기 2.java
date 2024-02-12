import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static int n;

    static void shellSort(int[] arr) {
        int h = n/2;
        int j, tmp;
        while(h>0) {
            for (int i = h; i < n; i++) {
                j = i-h;
                tmp = arr[i];
                while(j>=0 && arr[j]>tmp){
                    arr[j+h] = arr[j];
                    j-=h;
                }
                arr[j+h] = tmp;
            }
            h /= 2;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        
        shellSort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

}
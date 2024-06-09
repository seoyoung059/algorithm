import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]>[] arr = new ArrayList[11];
    static int answer;

    static void solve(int i, int sum, int check) {
        if(i==11){
            answer = Math.max(answer, sum);
            return;
        }
        for(int[] a: arr[i]){
            if((check&(1<<a[0]))!=0) continue;
            solve(i+1, sum+a[1], check|(1<<a[0]));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int tmp;

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < 11; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    tmp = Integer.parseInt(st.nextToken());
                    if(tmp==0) continue;
                    arr[j].add(new int[] {i, tmp});
                }
            }

//            for (int i = 0; i < 11; i++) {
//                for(int[]a: arr[i]){
//                    System.out.print(Arrays.toString(a)+" ");
//                }
//                System.out.println();
//            }

            answer = 0;
            solve(0, 0, 0);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
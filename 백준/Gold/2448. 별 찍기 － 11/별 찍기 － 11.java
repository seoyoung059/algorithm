import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb;


    static void solve(int n, int i, int j) {
        if(n==3){
            switch (i){
                case 0:
                    if(j==2) sb.append('*');
                    else sb.append(' ');
                    break;
                case 1:
                    if(j==1||j==3) sb.append('*');
                    else sb.append(' ');
                    break;
                case 2:
                    if(j==5) sb.append(' ');
                    else sb.append('*');
                    break;
            }
            return;
        }
        if(i < n/2){
            if(j < n/2 || j >= n*3/2)
                sb.append(' ');
            else solve(n/2,i%(n/2), j-(n/2));
        }  else{
            solve(n/2, i%(n/2), j%(n));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2; j++) {
                solve(n, i, j);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
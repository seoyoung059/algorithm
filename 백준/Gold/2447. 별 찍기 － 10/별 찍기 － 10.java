import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static void star(int y, int x, int n) {
        if (x/(n/3)==1 && y/(n/3)==1) {
            sb.append(" ");
        }
        else if (n>3) {
            star(y%(n/3), x%(n/3), n/3);
        }
        else {
            sb.append("*");
        }
    }
    
    static void solution(int n){
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                star(y,x,n);
            }
            sb.append("\n");
        }
    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        solution(n);
        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    private static int solution(int n) {
        int a = n/5;
        int b = n%5;
        while (a > -1){
            if (b%3==0)
                return a+b/3;
            else {
                a--;
                b += 5;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }
}

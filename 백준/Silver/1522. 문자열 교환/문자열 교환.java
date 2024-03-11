import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int n = str.length();
        int tmp = 0, cnt=0;
        for (int i = 0; i < n; i++) {
            tmp<<=1;
            if(str.charAt(i)=='b'){
                tmp|=1;
                cnt++;
            }
        }

        int check = (1<<cnt)-1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max=Math.max(Integer.bitCount(tmp&check), max);
            tmp <<=1;
            tmp = (tmp|(tmp>>n)&1);
        }
        System.out.println(cnt-max);
    }
}
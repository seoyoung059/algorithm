import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l, c, vowel;
    static char[] arr;
    static StringBuilder sb;
    static void solve(int idx, int check, int cnt){
        if(cnt==l){
            if((check&vowel)==0||(l-Integer.bitCount(check&vowel))<2) return;
            for (int i = 0; i < c; i++) {
                if((check&(1<<i))==(1<<i)){
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
        }

        for (int i = idx+1; i < c; i++) {
            solve(i, check|(1<<(i)), cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        vowel = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        for (int i = 0; i < c; i++) {
            if("aeiou".indexOf(arr[i])!=-1){
                vowel|=(1<<(i));
            }
        }
        for (int i = 0; i < c; i++) {
            solve(i,(1<<(i)),1);
        }
        System.out.println(sb);
    }
}
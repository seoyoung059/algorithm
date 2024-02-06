import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String num = br.readLine();
        int curr;
        for (int i = 0; i < n; i++) {
            curr = ((int) num.charAt(i))-((int)'0');
            while (!dq.isEmpty()&&n-m-dq.size() < n-i){
                if(dq.peekLast() >= curr) break;
                dq.pollLast();
            }
            if(dq.size() >= n-m) continue;
            dq.offerLast(curr);
        }
        for(Integer i: dq){
            sb.append(i);
        }
        System.out.println(sb.toString());
    }
}
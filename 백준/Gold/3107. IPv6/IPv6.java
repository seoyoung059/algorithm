import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine(),":");
//        System.out.println(st.countTokens());
//        int[] colon = new int[8];
//        int[] arr = new int[8];
        LinkedList<String> ll = new LinkedList<>();
        String ipv6 = br.readLine();
        //prev: 이전거가 :면 true
        int cnt=0;
        boolean prev = (ipv6.charAt(0)==':');
        for (int i = 1; i < ipv6.length(); i++) {
            if(ipv6.charAt(i)==':'){
                if(!prev) {
                    sb.append(ipv6.charAt(i-1));
                    ll.offer(sb.toString());
                    cnt++;
                } else {
                    ll.offer(" ");
                }
                sb = new StringBuilder();
                prev = true;
            }
            else {
                if(!prev)
                    sb.append((ipv6.charAt((i-1))));
                if (i==ipv6.length()-1)
                    sb.append(ipv6.charAt((i)));
                prev = false;
            }
        }
        ll.offer(sb.toString());
        cnt++;
        StringBuilder answer = new StringBuilder();
        for (String s: ll) {
            if(s.equals(" ")){
                for (int i = 0; i < 8-cnt; i++) {
                    answer.append("0000");
                    answer.append(":");
                }
            }
            else {
                for (int i = 0; i < 4-s.length(); i++) {
                    answer.append("0");
                }
                answer.append(s);
                answer.append(":");
            }
        }
        answer.setLength(39);
        System.out.println(answer.toString());
    }
}
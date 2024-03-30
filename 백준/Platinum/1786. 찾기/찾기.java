import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();
        int[] pi = new int[p.length()];

        int idx = 0;
        for (int i = 1; i < p.length(); i++) {
            while(idx>0 && p.charAt(i) != p.charAt(idx)) {
                idx = pi[idx-1];
            }
            if(p.charAt(i) == p.charAt(idx)){
                pi[i] = idx+1;
                idx++;
            }
        }


        idx = 0;
        int answer = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < t.length(); i++) {
            while(idx>0 && t.charAt(i) != p.charAt(idx)) {
//                System.out.println(t.charAt(i)+" "+p.charAt(idx));
                idx = pi[idx-1];
            }
            if(t.charAt(i)== p.charAt(idx)){

                if(idx == p.length()-1){
                    answer ++;
                    q.offer(i-idx+1);
                    idx = pi[idx];
                }
                else idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        while(!q.isEmpty()){
            sb.append(q.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(br.readLine());
            return;
        }
        int curr; int tmp;
        PriorityQueue<Integer> pqBig = new PriorityQueue<>();
        PriorityQueue<Integer> pqSmall = new PriorityQueue<>((o1, o2)->o2-o1);
        tmp = Integer.parseInt(br.readLine());
        curr = Integer.parseInt(br.readLine());
        if(curr>tmp){
            pqBig.offer(curr);
            pqSmall.offer(tmp);
        } else{
            pqBig.offer(tmp);
            pqSmall.offer(curr);
        }
        sb.append(tmp).append("\n").append(pqSmall.peek()).append("\n");
        for (int i = 2; i < n; i++) {
            curr = Integer.parseInt(br.readLine());
            if(pqBig.size() == pqSmall.size()){
                if(pqBig.peek()<curr){
                    pqSmall.offer(pqBig.poll());
                    pqBig.offer(curr);
                }
                else {
                    pqSmall.offer(curr);
                }
            }
            else {
                if(pqSmall.peek()>curr){
                    pqBig.offer(pqSmall.poll());
                    pqSmall.offer(curr);
                }
                else{
                    pqBig.offer(curr);
                }
            }
            sb.append(pqSmall.peek()).append("\n");
        }
        System.out.print(sb);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] lectures = new int[n+1];
        // 강의번호, 시작시간, 끝나는 시간 저장
        PriorityQueue<int[]> start = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
        // 강의번호, 끝나는 시간, 강의실 번호 저장
        PriorityQueue<int[]> end = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int newclassroom=1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
//        for(int[] a: start){
//            System.out.print(Arrays.toString(a));
//        }
//        System.out.println();
        int[] tmp; int[] endClass;
        while(!start.isEmpty()) {
            tmp = start.poll();

//            System.out.println("curr "+ Arrays.toString(tmp));
//            System.out.println("end "+ Arrays.toString(end.peek()));
            if(!end.isEmpty() && end.peek()[1] <= tmp[1]){
                endClass = end.poll();
                lectures[tmp[0]] = endClass[2];
                tmp[1] = tmp[2];
                tmp[2] = endClass[2];
                end.offer(tmp);
            }
            else {
                lectures[tmp[0]] = newclassroom;
                tmp[1]=tmp[2];
                tmp[2]=newclassroom++;
                end.offer(tmp);
            }
//            System.out.print("### end### ");
//            for(int[] a: end){
//                System.out.print(Arrays.toString(a));
//            }
//            System.out.println();
        }
//        System.out.println(Arrays.toString(lectures));
        StringBuilder sb = new StringBuilder();
        sb.append(newclassroom-1).append("\n");
        for (int i = 1; i <= n; i++) {
            sb.append(lectures[i]).append("\n");
        }
        System.out.print(sb);
    }
}
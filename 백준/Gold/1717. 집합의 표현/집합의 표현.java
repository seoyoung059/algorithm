import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] p;

    static int find(int x){
        if(p[x]==-1) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y){
        int tmp = find(x);
        int tmp2 = find(y);
        if(tmp==tmp2) return;
        if (tmp < tmp2) p[tmp2] = tmp;
        else p[tmp] = tmp2;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        p = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            p[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())){
                case 0:
                    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case 1:
                    if(find(Integer.parseInt(st.nextToken()))==find(Integer.parseInt(st.nextToken()))){
                        sb.append("yes");
                    } else sb.append("no");
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
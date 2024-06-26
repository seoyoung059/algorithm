import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Painting implements Comparable<Painting> {
        int h;
        int c;

        public Painting(int h, int c) {
            this.h = h;
            this.c = c;
        }

        @Override
        public int compareTo(Painting o) {
            return this.h - o.h;
        }
    }

    static int binarySearch(Painting[] arr, int h) {
        int s = 0, e = arr.length - 1, m;
        while (s <= e) {
            m = (s + e) / 2;
            if (arr[m].h > h) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();
        int h, c; Integer tmp;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
//            arr[i] = new Painting(h, c);
            tmp = hm.get(h);
            if(tmp==null||tmp<c){
                hm.put(h, c);
            }
        }
        int idx = 0;
        Painting[] arr = new Painting[hm.size()];
        for(Map.Entry<Integer, Integer> p: hm.entrySet()){
//            System.out.println(p);
            arr[idx++] = new Painting(p.getKey(), p.getValue());
        }

        Arrays.sort(arr);

        int[] dp = new int[hm.size()+1];
        for (int i = 0; i < hm.size(); i++) {
            dp[i + 1] = Math.max(dp[i], dp[binarySearch(arr, arr[i].h - s)] + arr[i].c);
        }

        System.out.println(dp[hm.size()]);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] chicken, house;
    static int houseNum, chickenNum;
    static int chickenDistance(int c, int h){
        return Math.abs(chicken[c][0]-house[h][0])+Math.abs(chicken[c][1]-house[h][1]);
    }

    static int sumCD(int[] set) {
        int answer = 0;
        int tmp;// = Integer.MAX_VALUE;
        for (int i = 0; i < houseNum; i++) {
            tmp = Integer.MAX_VALUE;
            for (int j = 0; j < chickenNum; j++) {
                if(set[j]==1)
                    tmp = Math.min(tmp, chickenDistance(j,i));
            }
            answer+=tmp;
        }
        return answer;
    }
    static void swap(int[] set, int i, int j){
        int tmp = set[i];
        set[i] = set[j];
        set[j] = tmp;
    }

    static boolean nextPermutation(int[] set) {
        int setL = set.length;
        int i=setL-1;
        while(i>0 && set[i-1] >= set[i]) i--;

        if(i==0) return false;

        int j=setL-1;
        while(set[i-1]>= set[j]) j--;

        swap(set, i-1, j);

        int k = setL-1;
        while(i<k) swap(set, i++, k--);

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new int[2*n][2];
        chicken = new int[13][2];

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                switch (arr[i][j]){
                    case 0:
                        break;
                    case 1:
                        house[houseNum][0] = i;
                        house[houseNum++][1] = j;
                        break;
                    case 2:
                        chicken[chickenNum][0] = i;
                        chicken[chickenNum++][1] = j;
                }
            }
        }

        int[] comb = new int[chickenNum];
        int cnt=0;
        for (int i = 0; i < m; i++) {
            comb[chickenNum-1-i]=1;
        }
        int answer = Integer.MAX_VALUE;

        do{
            answer = Math.min(answer, sumCD(comb));
        } while(nextPermutation(comb));
        System.out.println(answer);
    }
}
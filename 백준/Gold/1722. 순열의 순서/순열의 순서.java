import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void swap(int[] arr, int i, int j){
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    static boolean perm(int[] arr){
        int n = arr.length;
        int i = n-1;
        while(i>0 && arr[i-1]>=arr[i]) i--;
        if(i==0) return false;

        int j = n-1;
        while(j>i&&arr[i-1] >= arr[j]) j--;

        swap(arr, i-1, j);

        int k = n-1;
        while(i<k) swap(arr, i++, k--);
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int caseNum = Integer.parseInt(st.nextToken());
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = i+1;
//        }
//        int cnt=1;
        int check = 0;
        switch(caseNum){
            case 1:
                if(n==1) {
                    System.out.println(1);
                    return;
                }
                long k = Long.parseLong(st.nextToken())-1;
                 long tmp1 = 1; int cnt = 1;
                int[] arr = new int[n];
                for (int i = 1; i < 20; i++) {
                    if(tmp1*(i+1)>k) break;
                    tmp1*=(i+1);
                    cnt++;
                }
                for (int i = 0; i < n; i++) {
                    if(cnt<n-1-i) {
//                        System.out.println("i "+i);
                        for (int j = 1; j <= n; j++) {
                            if((check&(1<<j))==0) {
                                check|=(1<<j);
                                arr[i] = j;
                                break;
                            }
                        }
                    }
                    else {
//                        System.out.println(tmp1+ " "+cnt);
//                        arr[i] = (int) (k/tmp1);
                        long nn=0L;
                        for (int j = 1; j <= n; j++) {
                            if((check&(1<<j))==0){
                                if(nn==k/tmp1) {
                                    arr[i] = j;
                                    break;
                                }
                                else nn++;
                            }
                        }
                        k%=(long)tmp1;
                        if(cnt==0) {
                            for(int m:arr) sb.append(m).append(" ");
                            System.out.print(sb);
                            return;
                        }
                        tmp1/=cnt;
                        cnt--;
                        check|=(1<<arr[i]);
                    }
//                    System.out.println(check);
//                    System.out.println(Arrays.toString(arr));
                }
//                do{
//                    if(cnt==k) {
//                        for(int m: arr){
////                            System.out.print(m+" ");
//                            sb.append(m).append(" ");
//                        }
//                        System.out.println(sb);
//                        return;
//                    }
//                    cnt++;
//                }while(perm(arr));
                break;

            case 2:
                int[] input = new int[n];
                for (int i = 0; i < n; i++) {
                    input[i] = Integer.parseInt(st.nextToken());
                }

                long ans = 0L;
                for (int i = 0; i < n; i++) {
//                    int cnt = 0;
//                    System.out.println("input[i]: "+input[i]);
//                    System.out.println("check: "+Integer.toBinaryString((1<<(input[i]))-1));
//                    System.out.println(input[i]-1-Integer.bitCount(check&((1<<input[i])-1)));
                    int tmp = (input[i]-1-Integer.bitCount(check&((1<<input[i])-1)));
//                    System.out.println(tmp);
                    ans *= (n-i);
                    ans += (long)tmp;
                    check|=(1<<(input[i]-1));
//                    System.out.println(check);
                }
                System.out.println(ans+1);
                break;
        }
    }
}
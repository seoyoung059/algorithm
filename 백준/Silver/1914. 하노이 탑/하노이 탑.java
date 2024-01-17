import java.util.Scanner;
import java.math.BigInteger;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    private static void hanoii(int n, int s, int m, int e){
        if (n==1)
            sb.append(s+" "+e+"\n");
        else{
            hanoii(n-1,s,e,m);
            sb.append(s+" "+e+"\n");
            hanoii(n-1,m,s,e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        BigInteger num = new BigInteger("2");
        sb.append(num.pow(n).subtract(new BigInteger("1"))).append("\n");
        if (n<=20)
            hanoii(n,1,2,3);
        System.out.println(sb);
    }
}
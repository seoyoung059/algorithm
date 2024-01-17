import java.util.Scanner;

public class Main {

    private static int zSolution(int size, int r, int c) {
        if (size==1){
            return r*2+c;
        }
        else{
            int tmp = (int)(Math.pow(2,size-1));
            return
                    (int)(Math.pow(4,size-1))
                    *((r/(tmp))*2+(c/tmp))
                    +zSolution(size-1, r%tmp, c%tmp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(zSolution(n,r,c));

    }


}

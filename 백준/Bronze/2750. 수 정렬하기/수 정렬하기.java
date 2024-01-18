import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static void arraySort(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        int n = sc.nextInt();

        arraySort(n);
    }
}

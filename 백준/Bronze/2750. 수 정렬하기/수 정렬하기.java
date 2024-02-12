import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static BufferedReader br;
    static int n;

    static void insertionSort(int[] arr){
        int j, curr;
        for (int i = 1; i < n; i++) {
            j = i;
            curr = arr[i];
            while(j>0 && arr[j-1] > curr) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = curr;
        }
    }
    static void selectionSort(int[] arr) {
        int idx=0, curr;
        for (int i = 0; i < n; i++) {
            idx = i;
            curr = arr[i];
            for (int j = i+1; j < n; j++) {
                if(arr[j]<curr) {
                    idx = j;
                    curr = arr[j];
                }
            }
            if(i==idx) continue;
            arr[i]^=arr[idx];
            arr[idx]^=arr[i];
            arr[i]^=arr[idx];
        }
    }

    static  void bubbleSort(int[] arr){
        int tmp;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i ; j--) {
                if(arr[j-1] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    static void shakerSort(int[] arr) {
        int left = 0;
        int right = n-1;
        int last = right;
        int tmp;
        while(left < right){
            for (int i = right; i > left ; i--) {
                if(arr[i-1] > arr[i]) {
                    tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    last = i;
                }
            }
            left = last;
            for (int i = left; i < right; i++) {
                if(arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    last = i;
                }
            }
            right = last;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        switch ((int)(Math.random()*4)){
            case 0:
                insertionSort(arr);
                break;
            case 1:
                selectionSort(arr);
                break;
            case 2:
                bubbleSort(arr);
                break;
            default:
                shakerSort(arr);
        }
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }

}
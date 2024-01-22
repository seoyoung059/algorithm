import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> dwarfs = new ArrayList<Integer>();
        int sum = 0;
        int tmp;
        for (int i = 0; i < 9; i++) {
            tmp = Integer.parseInt(br.readLine());
            dwarfs.add(tmp);
            sum+=tmp;
        }
        dwarfs.sort(Integer::compareTo);
        int[] dArr = dwarfs.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum-dArr[i]-dArr[j]==100){
                    for (int k = 0; k < 9; k++) {
                        if (k!=i && k!=j)
                            System.out.println(dArr[k]);
                    }
                    return;
                }
            }
        }


    }
}

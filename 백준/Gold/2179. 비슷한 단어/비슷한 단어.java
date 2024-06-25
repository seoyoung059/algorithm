import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }


        HashMap<String, Integer> hm = new HashMap<>();
        String sub, str; int ans1=Integer.MAX_VALUE, ans2=Integer.MAX_VALUE, length = -1;
        for (int i = 0; i < n; i++) {
            str = arr[i];
            for (int j = 0; j < str.length()+1; j++) {
                sub = str.substring(0, j);
                if(hm.get(sub)!=null) {
                    if((length < sub.length() || (length==sub.length() && ans1 > hm.get(sub))) && !arr[i].equals(arr[hm.get(sub)])) {
                        ans1 = hm.get(sub);
                        ans2 = i;
                        length = sub.length();
                    }
                } else {
                    hm.put(str.substring(0, j), i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[ans1]).append("\n").append(arr[ans2]);
        System.out.println(sb);
    }
}
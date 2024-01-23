import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.length()-o2.length()==0){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        
        for (int i = 0; i < n; i++) {
            ts.add(br.readLine());
        }

        for(String s:ts){
            System.out.println(s);
        }
    }
}

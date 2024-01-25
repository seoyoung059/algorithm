import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static HashMap<Character, int[]> keymap;
    private static StringBuilder sb = new StringBuilder();

    private static HashMap<Character, int[]> alphabetMap() {
        HashMap<Character, int[]> map = new HashMap<>();
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < keyboard[i].length(); j++) {
                map.put(keyboard[i].charAt(j), new int[]{i,j});
            }
        }
        return map;
    }

    private static int charDistance(char a, char b) {
        return Math.abs(keymap.get(a)[0] - keymap.get(b)[0]) +
                Math.abs(keymap.get(a)[1] - keymap.get(b)[1]);
    }

    static class wordNode {
        int distance;
        String word;

        public wordNode(int distance, String word) {
            this.distance = distance;
            this.word = word;
        }

        @Override
        public String toString() {
            return this.word + " " + this.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        keymap = alphabetMap();
        PriorityQueue<wordNode> wordQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) return o1.word.compareTo(o2.word);
            return o1.distance - o2.distance;
        });

        String userWord;
        String newWord;
        int wordNum;
        int sum;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            userWord = st.nextToken();
            wordNum = Integer.parseInt(st.nextToken());
            for (int i = 0; i < wordNum; i++) {
                sum = 0;
                st = new StringTokenizer(br.readLine());
                newWord = st.nextToken();
                for (int j = 0; j < userWord.length(); j++) {
                    sum += charDistance(userWord.charAt(j), newWord.charAt(j));
                }
                wordQueue.offer(new wordNode(sum, newWord));
            }

            while (!wordQueue.isEmpty()) {
                sb.append(wordQueue.poll().toString());
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

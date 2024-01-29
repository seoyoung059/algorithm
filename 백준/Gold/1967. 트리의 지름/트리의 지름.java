import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static TreeNode[] arr;
    static TreeNode root;
//    static PriorityQueue<Integer> pq;
    static int answer;
    static class TreeNode {
        int num;
        int parent;
        int weight;
        int maxWeightSum;
        LinkedList<TreeNode> childs;


        public TreeNode(int num, int parent, int weight){
            this.num = num;
            this.parent = parent;
            this.weight = weight;
            this.childs = new LinkedList<>();
        }

    }

    static int dfs(TreeNode currNode) {
//        System.out.println("Node "+currNode.num);
        if (currNode.childs.isEmpty())
            return currNode.weight;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
        for(TreeNode n: currNode.childs){
            pq.offer(dfs(n));
        }
//        System.out.println(pq.toString());
        int max = pq.poll();
        int next = (pq.isEmpty())?0:pq.peek();
        answer = Math.max(answer,max+next);
//        System.out.println("Node "+currNode.num + " "+answer);
//        System.out.println(max+currNode.weight);
        return max + currNode.weight;

    }
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new TreeNode[n+1];
        root = new TreeNode(1,0, 0);
        arr[1] = root;
        int parent; int curr; int weight;

        for (int i = 2; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            curr = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            arr[curr] = new TreeNode(curr,parent, weight);
        }

        for (int i = 2; i < n+1; i++) {
            arr[arr[i].parent].childs.offer(arr[i]);
        }

        answer = 0;
        dfs(root);

        System.out.println(answer);
    }
}

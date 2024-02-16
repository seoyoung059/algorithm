import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class SegmentTree {
        private int[] tree;
        private int arrSize;
        private int nodeNum;
        private int treeHeight;

        SegmentTree(int[] arr){
            this.arrSize = arr.length;
            this.treeHeight = (int) Math.ceil(Math.log(this.arrSize)/Math.log(2));
            this.nodeNum = (1<<(this.treeHeight+1));
            this.tree = new int[nodeNum];
            buildTree(arr, 0, this.arrSize-1, 0);
        }

        private void buildTree(int[] arr, int low, int high, int pos){
            if(low==high){
                this.tree[pos] = arr[low];
                return;
            }
            int mid = (low+high)/2;
            buildTree(arr, low, mid, pos*2+1);
            buildTree(arr, mid+1, high, pos*2+2);
            this.tree[pos] = Math.min(this.tree[2*pos+1], this.tree[2*pos+2]);
        }

        private int _getRangeQuery(int qlow, int qhigh, int low, int high, int pos){
            if(qlow <= low && high <= qhigh){
                return this.tree[pos];
            }
            else if(qhigh < low || high < qlow){
                return Integer.MAX_VALUE;
            }
            else {
                int mid = (low+high)/2;
                return Math.min(_getRangeQuery(qlow, qhigh, low, mid, 2*pos+1),
                            _getRangeQuery(qlow, qhigh, mid+1, high, 2*pos+2));
            }
        }

        int getRangeQuery(int qlow, int qhigh){
            return _getRangeQuery(qlow, qhigh, 0, this.arrSize-1, 0);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segTree = new SegmentTree(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(segTree.getRangeQuery(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1)).append("\n");
        }
        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        int[][] tree;
        int treeHeight;
        int arrLength;
        int nodeNum;

        SegmentTree(int[] arr) {
            this.arrLength = arr.length;
            this.treeHeight = (int) Math.ceil(Math.log(this.arrLength) / Math.log(2));
            this.nodeNum = (1 << (this.treeHeight + 1));
            this.tree = new int[nodeNum][2];
            _constructTree(arr, 0, this.arrLength - 1, 0);
        }

        private void _constructTree(int[] arr, int low, int high, int pos) {
            if (low == high) {
                this.tree[pos][0] = arr[low];
                this.tree[pos][1] = arr[low];
                return;
            }
            int mid = (low + high) / 2;
            _constructTree(arr, low, mid, pos * 2 + 1);
            _constructTree(arr, mid + 1, high, pos * 2 + 2);
            this.tree[pos][0] = Math.min(this.tree[pos * 2 + 1][0], this.tree[pos * 2 + 2][0]);
            this.tree[pos][1] = Math.max(this.tree[pos * 2 + 1][1], this.tree[pos * 2 + 2][1]);
        }

        private int _getMinQuery(int qlow, int qhigh, int low, int high, int pos) {
            if (qlow <= low && high <= qhigh) {
                return this.tree[pos][0];
            }
            if (qhigh < low || high < qlow) {
                return Integer.MAX_VALUE;
            }
            int mid = (low + high) / 2;
            return Math.min(_getMinQuery(qlow, qhigh, low, mid, pos * 2 + 1),
                    +_getMinQuery(qlow, qhigh, mid + 1, high, pos * 2 + 2));
        }

        int getMinQuery(int qlow, int qhigh) {
            return _getMinQuery(qlow, qhigh, 0, this.arrLength - 1, 0);
        }

        private int _getMaxQuery(int qlow, int qhigh, int low, int high, int pos) {
            if (qlow <= low && high <= qhigh) {
                return this.tree[pos][1];
            }
            if (qhigh < low || high < qlow) {
                return Integer.MIN_VALUE;
            }
            int mid = (low + high) / 2;
            return Math.max(_getMaxQuery(qlow, qhigh, low, mid, pos * 2 + 1),
                    +_getMaxQuery(qlow, qhigh, mid + 1, high, pos * 2 + 2));
        }

        int getMaxQuery(int qlow, int qhigh) {
            return _getMaxQuery(qlow, qhigh, 0, this.arrLength - 1, 0);
        }
    }

    public static void main(String[] args) throws Exception {
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
        int min, max, a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
//            System.out.println(a+" "+b);
            min = segTree.getMinQuery(a, b);
            max = segTree.getMaxQuery(a, b);
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}